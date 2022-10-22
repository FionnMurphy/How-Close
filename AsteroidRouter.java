package com.example.HowClose;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class AsteroidRouter {

    @Bean
    public RouterFunction<ServerResponse> route(AsteroidHandler asteroidHandler){
        return RouterFunctions.route(GET("api/asteroids").and(accept(MediaType.APPLICATION_JSON)), asteroidHandler::asteroids);
    }
}
