package com.pseudowasabilabs.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstAppController {

    private static final Logger log = LoggerFactory.getLogger(FirstAppController.class);

    @GetMapping("/hello")
    private String hello() {
        return "Hello first app user";
    }

    @GetMapping("/message")
    private String message(@RequestHeader("req1") String header) {
        log.info(header);
        return "First app test";
    }

    @GetMapping("/check")
    private String check() {
        return "Hi, check";
    }
}
