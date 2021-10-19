package com.albertsons.registration.client;

import com.albertsons.registration.model.RegisterRequest;
import com.albertsons.registration.model.okta.OktaResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class OktaClient {
    public Mono<OktaResponse> register(RegisterRequest registerRequest) {
        return Mono.just(new OktaResponse());
    }
}
