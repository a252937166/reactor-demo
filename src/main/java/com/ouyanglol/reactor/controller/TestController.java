package com.ouyanglol.reactor.controller;

import org.apache.logging.log4j.message.ObjectMessage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author ouyangduning
 * @date 2020/10/25 22:31
 */
@RestController
public class TestController {

    @GetMapping("/message")
    public Mono<String> messageBaseResponse() {
        return Mono.create(sink -> {
            sink.success("ok");
            sink.onDispose(()->{
                System.out.println("222222222");
            });
            sink.onRequest(s->{
                System.out.println("r");
            });
            sink.onCancel(()->{
                System.out.println("11111");
            });
        });
    }

}
