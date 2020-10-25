package com.ouyanglol.reactor.handler;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.management.Notification;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 * @author ouyangduning
 * @date 2020/10/25 18:07
 */
@Component
public class TimeHandler {
    public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);
    }

    public Mono<ServerResponse> getDate(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Today is " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())), String.class);
    }

    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        Flux<String> map = Flux.interval(Duration.ofSeconds(1))
                .publishOn(Schedulers.newElastic("publish-thread"))
                .map(l -> new SimpleDateFormat("HH:mm:ss").format(new Date()));
        return ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.merge(map,getHeartbeatStream()), String.class);
    }

    private Flux<ServerSentEvent<Notification>> getHeartbeatStream() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> ServerSentEvent.<Notification>builder().event("ping").build())
                .doFinally(signalType ->System.out.println("END"));
    }
}
