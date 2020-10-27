package com.ouyanglol.reactor.domain.user.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.ouyanglol.reactor.domain.user.entity.User;

/**
 * @author ouyangduning
 */
public interface UserRepository extends ReactiveCrudRepository<User, String> {

    @Tailable
    Flux<User> findBy();

    Flux<User> insert(Flux<User> user);

    Mono<User> findByUsername(String username);

    Mono<User> findByName(String name);

    Mono<Long> deleteByUsername(String username);

    @Query("{'name':?0}")
    Flux<User> findWithName(String name);

}