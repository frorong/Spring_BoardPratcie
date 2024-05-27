package com.example.board_practice.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    @GetMapping("/list")
    List<Response> getBoardList() {
        return boardRepository.findAll().stream().map(item ->
                Response.builder()
                        .title(item.getTitle())
                        .content(item.getContent())
                        .createdAt(item.getCreatedAt())
                        .id(item.getId())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
