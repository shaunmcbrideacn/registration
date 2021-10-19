package com.albertsons.registration.service;

import com.albertsons.registration.client.DynamicsHealthClient;
import com.albertsons.registration.client.IdentityServerClient;
import com.albertsons.registration.client.OktaClient;
import com.albertsons.registration.model.RegisterRequest;
import com.albertsons.registration.model.RegisterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RegisterService {

    private final OktaClient oktaClient;
    private final IdentityServerClient identityServerClient;
    private final DynamicsHealthClient dynamicsHealthClient;

    public RegisterService(OktaClient oktaClient, IdentityServerClient identityServerClient, DynamicsHealthClient dynamicsHealthClient) {
        this.oktaClient = oktaClient;
        this.identityServerClient = identityServerClient;
        this.dynamicsHealthClient = dynamicsHealthClient;
    }


    public Mono<RegisterResponse> register(RegisterRequest registerRequest){
        return oktaClient.register(registerRequest)
                .flatMap(okta -> identityServerClient.register(registerRequest))
                .flatMap(is -> dynamicsHealthClient.register(registerRequest))
                .map(dynamicsResponse ->  new RegisterResponse());
    }

}
