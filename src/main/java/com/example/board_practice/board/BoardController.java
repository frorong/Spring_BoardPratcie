package com.example.board_practice.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    Response getBoardDetail (@PathVariable("id") Integer id) {
        BoardEntity board = boardRepository.findById(id).orElse(null);

        return Response.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdAt(board.getCreatedAt())
                    .id(board.getId())
                    .build();
    }
}
