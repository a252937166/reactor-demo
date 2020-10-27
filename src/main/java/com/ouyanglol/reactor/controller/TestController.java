package com.ouyanglol.reactor.controller;


import com.ouyanglol.reactor.domain.user.repository.CityRepository;
import com.ouyanglol.reactor.domain.user.valueobject.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author ouyangduning
 * @date 2020/10/25 22:31
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(value = "/message", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<City> messageBaseResponse() {
        Flux<City> by = cityRepository.findBy();
        return by.doOnNext(s->log.info("{}",s));
    }

}
