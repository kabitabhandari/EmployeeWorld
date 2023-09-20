//package com.example.employeeworld.jwtsecurity.config;
//
//import com.example.employeeworld.jwtsecurity.service.JWTAuthenticationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
//public class SecurityConfig {
//    private static final String[] AUTH_WHITELIST = {
//        // Permit requests for actuator endpoints
//        "/actuator/health/**",
//        "/actuator/info/**",
//        "/actuator/loggers/**",
//        "/actuator/prometheus/**",
//        // Permit Swagger
//        "/v3/api-docs/**",
//        "/swagger-ui/**",
//        "/swagger-resources/**",
//        "/swagger-ui.html",
//        // Permit jwt token endpoints
//        "/jwt/**"
//    };
//
//    private final JWTAuthenticationFilter jwtAuthenticationFilter;
//    private final AuthenticationProvider authenticationProvider;
//
//    @Bean
//    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
//        return new MvcRequestMatcher.Builder(introspector);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(
//            HttpSecurity httpSecurity, MvcRequestMatcher.Builder mvc) throws Exception {
//        httpSecurity
//                // disable csrf
//                .csrf(AbstractHttpConfigurer::disable)
//                // don't create http sessions
//                .sessionManagement(
//                        sessionManagementConfig ->
//                                sessionManagementConfig.sessionCreationPolicy(
//                                        SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(
//                        authorize ->
//                                authorize
//                                        .requestMatchers(mvc.pattern("/jwt/**"))
//                                        .permitAll()
//                                        .anyRequest()
//                                        .authenticated())
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(
//                        jwtAuthenticationFilter,
//                        UsernamePasswordAuthenticationFilter.class); // before calling
//        // username-and-password-authentication-filter I want to
//        // use this filter
//
//        return httpSecurity.build();
//    }
//}
