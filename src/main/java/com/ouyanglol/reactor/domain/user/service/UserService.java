package com.ouyanglol.reactor.domain.user.service;

import reactor.core.publisher.Flux;
import com.ouyanglol.reactor.domain.user.entity.User;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/10/26 21:16
 */
public interface UserService {
    Flux<User> findAll();

    Flux<User> save(Flux<User> user);

    Mono<User> findByName(String name);
}
