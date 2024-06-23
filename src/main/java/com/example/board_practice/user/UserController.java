package com.example.board_practice.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping
    ResponseEntity getUser(HttpServletRequest request, RequestDto dto) {
        UserEntity targetUser = userService.loadUserByUsername(dto.getEmail());

        return ResponseEntity.ok(targetUser);
    }
}