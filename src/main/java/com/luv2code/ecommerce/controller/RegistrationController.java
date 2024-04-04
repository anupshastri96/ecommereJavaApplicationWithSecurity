package com.luv2code.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.ecommerce.dto.UserDTO;
import com.luv2code.ecommerce.service.RegistrationService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RegistrationController {

private final RegistrationService registrationService;

public RegistrationController(RegistrationService registrationService) {
	this.registrationService = registrationService;
}

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
    // Call a service method to handle Okta registration
	
    boolean isRegistered = registrationService.registerUser(userDTO);
    if (isRegistered) {
      return ResponseEntity.ok().body("User registered successfully!");
    } else {
      return ResponseEntity.badRequest().body("Registration failed!");
    }
  }
}
