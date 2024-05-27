package com.example.board_practice.board;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Response {
    private String title;
    private String content;
    private int id;
    private LocalDateTime createdAt;
}
