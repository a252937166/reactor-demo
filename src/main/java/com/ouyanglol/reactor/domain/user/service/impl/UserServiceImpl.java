package com.ouyanglol.reactor.domain.user.service.impl;

import com.ouyanglol.reactor.domain.user.entity.User;
import com.ouyanglol.reactor.domain.user.repository.UserRepository;
import com.ouyanglol.reactor.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/10/26 21:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Flux<User> findAll() {
        return userRepository.findWithName("ok");
    }

    @Override
    public Flux<User> save(Flux<User> user) {
        return userRepository.insert(user);
    }

    @Override
    public Mono<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
