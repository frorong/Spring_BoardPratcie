package com.example.board_practice.board;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ResponseEntity {
    private String title;
    private String content;
    private Integer id;
    private LocalDateTime createdAt;
}
