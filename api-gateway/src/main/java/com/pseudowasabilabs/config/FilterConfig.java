package com.pseudowasabilabs.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                             .filters(f -> f.addRequestHeader("req1", "req1-value")
                                            .addResponseHeader("resp1", "resp1-value"))
                                            .uri("http://localhost:8081/"))
                .route(r -> r.path("/second-service/**")
                             .filters(f -> f.addRequestHeader("req2", "req2-value")
                                            .addResponseHeader("resp2", "resp2-value"))
                                            .uri("http://localhost:8082"))
                .build();
    }
}
