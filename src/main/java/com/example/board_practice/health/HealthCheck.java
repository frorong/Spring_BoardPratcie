package com.example.board_practice.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheck {
    @GetMapping("/api/health")
    org.springframework.http.ResponseEntity healthCheck() {
        return ResponseEntity.ok().build();
    }
}
