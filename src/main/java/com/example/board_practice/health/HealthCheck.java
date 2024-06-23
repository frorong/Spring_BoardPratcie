package com.example.board_practice.health;

import com.example.board_practice.board.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheck {
    @GetMapping("/api/health")
    ResponseEntity<ResponseDto> healthCheck() {
        return ResponseEntity.ok().build();
    }
}
