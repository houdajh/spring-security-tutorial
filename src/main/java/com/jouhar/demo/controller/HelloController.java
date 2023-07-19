package com.jouhar.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}