package com.pseudowasabilabs.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
/**
 * EnableEurekaClient : only for Eureka
 * EnableDiscoveryClient : supports various service registry (Eureka, Consul, Zookeeper, etc...)
 */
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
