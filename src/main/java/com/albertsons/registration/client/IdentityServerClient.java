package com.albertsons.registration.client;

import com.albertsons.registration.model.RegisterRequest;
import com.albertsons.registration.model.identityserver.IndentityServerResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class IdentityServerClient {
    public Mono<IndentityServerResponse> register(RegisterRequest registerRequest) {

        return Mono.just(new IndentityServerResponse());
    }
}
