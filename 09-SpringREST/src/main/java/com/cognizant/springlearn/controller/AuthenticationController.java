package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public Map<String, String> generateJwtToken(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START: JWT Authentication Token Generation");
        
        // Extract the Base64 encoded username:password from the Basic Auth header
        String base64Credentials = authHeader.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        
        // Split username and password (e.g., "user:pwd")
        String username = credentials.split(":", 2)[0];
        
        // Generate the token
        String token = jwtUtil.generateToken(username);
        
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        
        LOGGER.info("END: Token successfully generated for user: {}", username);
        return response;
    }
}