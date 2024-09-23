package com.pseudowasabilabs.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/second-service")
public class SecondAppController {

    // not assigned properly
    @Value("local.server.port")
    private String localServerPort;

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

    @GetMapping("/check")
    private String check(HttpServletRequest request) {
        log.info("== Local server port: {}", request.getServerPort());

        return String.format("message from second-app, port(yml): %s, port(httpservlet): %s", localServerPort, request.getServerPort());
    }
}
