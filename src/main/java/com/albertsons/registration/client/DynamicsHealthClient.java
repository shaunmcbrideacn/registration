package com.albertsons.registration.client;

import com.albertsons.registration.model.RegisterRequest;
import com.albertsons.registration.model.dynamics.DynamicsResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DynamicsHealthClient {

    private final ActiveDirectoryClient activeDirectoryClient;

    public DynamicsHealthClient(ActiveDirectoryClient activeDirectoryClient) {
        this.activeDirectoryClient = activeDirectoryClient;
    }

    public Mono<DynamicsResponse> register(RegisterRequest registerRequest) {
        return Mono.just(new DynamicsResponse());
    }
}
