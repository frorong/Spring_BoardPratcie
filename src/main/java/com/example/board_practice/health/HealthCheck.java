package com.example.board_practice.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheck {
    @GetMapping("/api/v1/board/health")
    String healthCheck() {
        return "200 ok";
    }
}
