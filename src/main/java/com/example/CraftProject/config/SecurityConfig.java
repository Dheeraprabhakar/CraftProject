package com.example.CraftProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    // Security filter chain configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Authorize requests configuration
                .authorizeHttpRequests((requests) -> requests
                        // Public endpoints
                        .requestMatchers("/api/v2/**").permitAll()   // No authentication required
                        // Private endpoints (require authentication)
                        //.requestMatchers("/api/v1/**").authenticated()  // Authentication required //.authenticated()
                        .requestMatchers("/api/v1/**").hasRole("ADMIN")
                )
                // Enable basic authentication (username and password)
                .httpBasic()  // Use basic auth
                .and()
                // Disable CSRF for simplicity (typically enabled in real apps)
                .csrf().disable();  // Not recommended for production unless justified

        return http.build();
    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/api/v1/public/**").permitAll() // Public APIs
//                        .requestMatchers("/api/v1/secure/**").authenticated() // Secure APIs
//                )
//                .formLogin() // You can configure login here
//                .and()
//                .httpBasic(); // Basic Auth can be configured as needed
//
//        return http.build();
//    }

    // In-memory user details service for authentication
    @Bean
    public UserDetailsService userDetailsService() {
//        var userDetailsService = new InMemoryUserDetailsManager();
//
//        // Create a user with username 'user' and password 'password'
//        var user = User.withUsername("user")
//                .password("{noop}password")  // {noop} means no password encoding
//                .roles("USER")
//                .build();
//
//        userDetailsService.createUser(user);
//
//        return userDetailsService;

        // Define users with roles
        var admin = User.withUsername("admin")
                .password("{noop}admin123")  // {noop} is for plaintext passwords (not recommended in production)
                .roles("ADMIN")
                .build();

        var user = User.withUsername("user")
                .password("{noop}user123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
