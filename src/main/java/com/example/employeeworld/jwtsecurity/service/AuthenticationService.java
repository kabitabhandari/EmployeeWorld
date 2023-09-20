//package com.example.employeeworld.jwtsecurity.service;
//
//import com.example.employeeworld.jwtsecurity.jwtmodel.*;
//import com.example.employeeworld.jwtsecurity.repository.JWTUserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
///** Interact with database to register user */
//public class AuthenticationService {
//    private final JWTUserRepository repository;
//    private final PasswordEncoder passwordEncoder;
//    private final JWTService jwtService;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthenticationResponse register(RegisterRequest request) {
//        var user =
//                User.builder()
//                        .firstname(request.getFirstname())
//                        .lastname(request.getLastname())
//                        .email(request.getEmail())
//                        .secret(passwordEncoder.encode(request.getPassword()))
//                        .role(Role.User)
//                        .build();
//        repository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//
//        return AuthenticationResponse.builder().token(jwtToken).build();
//    }
//
//    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//        var user = repository.findByEmail(request.getEmail()).orElseThrow();
//        var jwtToken = jwtService.generateToken(user);
//
//        return AuthenticationResponse.builder().token(jwtToken).build();
//    }
//}
