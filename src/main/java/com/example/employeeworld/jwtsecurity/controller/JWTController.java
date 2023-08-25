package com.example.employeeworld.jwtsecurity.controller;

import com.example.employeeworld.jwtsecurity.jwtmodel.AuthenticationRequest;
import com.example.employeeworld.jwtsecurity.jwtmodel.AuthenticationResponse;
import com.example.employeeworld.jwtsecurity.jwtmodel.RegisterRequest;
import com.example.employeeworld.jwtsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
@RequiredArgsConstructor
//Generates a constructor for final fields.
public class JWTController {
    private final AuthenticationService service;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }
}
