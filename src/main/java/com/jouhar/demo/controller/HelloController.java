package com.jouhar.demo.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/user")
    public String user() {
        return "Welcome user!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome admin!";
    }

    @GetMapping("/debug")
    public String debug(Principal principal) {
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
            System.out.println("User roles: " + token.getAuthorities());
        }
        return "Debug endpoint";
    }
}