package com.albertsons.registration.controller;

import com.albertsons.registration.model.RegisterRequest;
import com.albertsons.registration.model.RegisterResponse;
import com.albertsons.registration.service.RegisterService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<RegisterResponse> register(@RequestBody RegisterRequest request){
        return registerService.register(request);
    }
}
