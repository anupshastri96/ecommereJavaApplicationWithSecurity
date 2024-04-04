package com.luv2code.ecommerce.service;

import com.okta.sdk.client.Client;
import com.okta.sdk.resource.user.User;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.sdk.resource.user.UserStatus;

import org.springframework.stereotype.Service;

import com.luv2code.ecommerce.dto.UserDTO;

@Service
public class RegistrationService {

    private final Client oktaClient;

    // Inject Okta's Client into your service
    public RegistrationService(Client oktaClient) {
        this.oktaClient = oktaClient;
    }

    public boolean registerUser(UserDTO userDTO) {
        User user = UserBuilder.instance()
                .setEmail(userDTO.getEmail())
                .setFirstName(userDTO.getFirstName())
                .setLastName(userDTO.getLastName())
                .setPassword(userDTO.getPassword().toCharArray())
                // .setSecurityQuestion("Favorite security question?")
                // .setSecurityQuestionAnswer("Your answer")
                .setActive(true)
                .buildAndCreate(oktaClient); // This will create and activate the user immediately
        
        return user.getStatus() == UserStatus.ACTIVE;
    }
	}
