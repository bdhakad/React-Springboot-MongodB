package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
	
	@RequestMapping(value = "/health")
    ResponseEntity<String> home() {
        return ResponseEntity.ok().body("{ \"message\" : \"App is up and running\"}");
    }
}
