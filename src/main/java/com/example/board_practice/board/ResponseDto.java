package com.example.board_practice.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String title;
    private String content;
    private Integer id;
    private LocalDateTime createdAt;
}
