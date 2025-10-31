package com.willjager.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String index() {
        return "GET: Hello from auth service";
    }

    @PostMapping
    public String postIndex() {
        return "POST: Hello from auth service";
    }
}
