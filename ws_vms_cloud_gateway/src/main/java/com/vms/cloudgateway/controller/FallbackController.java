package com.vms.cloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/registrationfallback")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Registration Service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/offerservicefallback")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Offer Service is taking too long to respond or is down. Please try again later");
    }
}