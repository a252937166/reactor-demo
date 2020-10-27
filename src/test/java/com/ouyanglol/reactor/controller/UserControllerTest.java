package com.ouyanglol.reactor.controller;

import com.ouyanglol.reactor.DemoApplicationTests;
import com.ouyanglol.reactor.domain.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;

/**
 * @author ouyangduning
 * @date 2020/10/26 22:51
 */
@Slf4j
class UserControllerTest extends DemoApplicationTests {


    @Test
    void save() {
        Flux<User> eventFlux = Flux.interval(Duration.ofSeconds(1))
                .map(l -> User.builder().name("ok").email(UUID.randomUUID().toString()).build()).take(5).doOnNext(e -> log.info("{}", e)); // 1
        WebClient webClient = WebClient.create("http://localhost:8080");
        webClient
                .post().uri("/user/save")
                .contentType(MediaType.APPLICATION_STREAM_JSON) // 2
                .body(eventFlux, User.class) // 3
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Test
    void all() {
        WebClient webClient = WebClient.create("http://localhost:8080");
        webClient
                .get().uri("/user/all")
                .accept(MediaType.APPLICATION_STREAM_JSON)    // 1
                .retrieve()
                .bodyToFlux(User.class)
                .log()  // 2
                .take(10)   // 3
                .blockLast();
    }
}