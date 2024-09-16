package com.pseudowasabilabs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class SecondAppController {

    @GetMapping("/hello")
    private String hello() {
        return "Hello second app user";
    }
}
