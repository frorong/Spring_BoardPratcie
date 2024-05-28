package com.example.board_practice.board;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestEntity {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
