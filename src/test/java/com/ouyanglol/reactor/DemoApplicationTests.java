package com.ouyanglol.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
@Slf4j
public class DemoApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        AtomicInteger a = new AtomicInteger();
        Flux<String> longFlux =Flux.interval(Duration.ofMillis(1)).map(i->{
            log.info("->?{}",i);
            return "b";
        }).map(b-> b+"a");
        //take方法准确获取订阅数据量
        Disposable disposable = longFlux.subscribe(x->{
            a.getAndIncrement();
            log.info("->{},{}",x,a);
        });
        //不能停止正在推送数据中的Flux或Mono流
        Thread.sleep(100);
        //彻底停止正在推送数据中的Flux或Mono流
        disposable.dispose();
        log.info("->Stop");
    }

}
