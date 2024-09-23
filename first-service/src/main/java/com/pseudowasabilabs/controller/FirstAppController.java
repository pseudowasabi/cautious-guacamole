package com.pseudowasabilabs.controller;

import com.pseudowasabilabs.FirstApplication;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstAppController {

    Environment env;

    @Autowired
    public FirstAppController(Environment env) {
        this.env = env;
    }

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
    private String check(HttpServletRequest request) {
        log.info("== Local server port: {}", request.getServerPort());

        return String.format("message from first-app, port(yml): %s, port(httpservlet): %s", env.getProperty("local.server.port"), request.getServerPort());
    }
}
