package com.example.board_practice.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/board")
@RestController
public class Endpoints {
    @GetMapping("/health")
    String healthCheck() {
        return "200 ok";
    }
}
