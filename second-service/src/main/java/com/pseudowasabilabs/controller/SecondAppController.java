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
@RequestMapping("/second-service")
public class SecondAppController {

    private static final Logger log = LoggerFactory.getLogger(SecondAppController.class);

    @GetMapping("/hello")
    private String hello() {
        return "Hello second app user";
    }

    @GetMapping("/message")
    private String message(@RequestHeader("req2") String header) {
        log.info(header);
        return "Second app test";
    }
}
