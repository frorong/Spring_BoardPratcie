package com.example.board_practice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(RequestEntity request) {
        userService.saveUser(request);
        return "redirect:/login";
    }
}