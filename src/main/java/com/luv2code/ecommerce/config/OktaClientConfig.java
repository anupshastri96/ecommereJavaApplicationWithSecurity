package com.luv2code.ecommerce.config;

import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OktaClientConfig {

    @Bean
    public Client oktaClient() {
        return Clients.builder()
                .setOrgUrl("https://dev-87743704.okta.com/oauth2/default") // Replace with your Okta domain
                .setClientCredentials(new TokenClientCredentials("00BJVFuNV57-m1DktfhFm0C8pjGqCQMENvZWKK2mp7")) // Replace with your API token
                .build();
    }
}

