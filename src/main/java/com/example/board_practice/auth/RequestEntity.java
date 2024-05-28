package com.example.board_practice.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestEntity {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
