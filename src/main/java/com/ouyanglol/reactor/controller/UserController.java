package com.ouyanglol.reactor.controller;

import com.ouyanglol.reactor.domain.user.entity.User;
import com.ouyanglol.reactor.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author ouyangduning
 * @date 2020/10/26 21:14
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> save(@RequestBody Flux<User> user) {
        return userService.save(user);
    }

    @GetMapping(value = "all",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> all() {
        return userService.findAll();
    }
}
