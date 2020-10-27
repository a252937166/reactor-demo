package com.ouyanglol.reactor.domain.user.repository;

import com.ouyanglol.reactor.domain.user.valueobject.City;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author ouyangduning
 */
public interface CityRepository extends ReactiveCrudRepository<City, String> {
    @Tailable
    Flux<City> findBy();
}