package com.user.tracking.controller;

import com.user.tracking.service.TrackingNumberGeneratorService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackingNumberController {

    @Autowired
    private TrackingNumberGeneratorService trackingNumberGeneratorService;

    @RequestMapping(value = "/v1/command/generateuniquenumber",method = RequestMethod.GET)
    public String generateTrackingNumber() {
        return trackingNumberGeneratorService.generateTrackingNumber();
    }

}

