package com.example.board_practice.board;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Request {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
