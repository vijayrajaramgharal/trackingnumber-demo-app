package com.user.tracking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import java.time.Duration;

@Configuration
public class Resilience4jConfig {

    @Bean
    public CircuitBreaker circuitBreaker() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50) // failure rate threshold percentage
                .waitDurationInOpenState(Duration.ofMillis(10000)) // how long the circuit breaker stays open
                .permittedNumberOfCallsInHalfOpenState(10) // how many calls are permitted when the circuit is half-open
                .slidingWindowSize(10) // sliding window size
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);
        return registry.circuitBreaker("trackingNumberServiceCircuitBreaker");


    }
}

