package com.example.board_practice.board;

import java.util.List;
import java.util.stream.Collectors;

public class BoardServiece {
    private final BoardRepository boardRepository;

    public BoardServiece(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    List<ResponseEntity> findBoardList() {
        List<ResponseEntity> responseBoardList = boardRepository.findAll().stream().map(item -> ResponseEntity.builder().title(item.getTitle()).content(item.getContent()).createdAt(item.getCreatedAt()).id(item.getId()).build()).collect(Collectors.toList());
        return responseBoardList;
    }

    ResponseEntity findBoardById(Integer id) {
        BoardEntity targetBoard = boardRepository.findById(id).orElse(null);

        return ResponseEntity.builder()
                .title(targetBoard.getTitle())
                .content(targetBoard.getContent())
                .createdAt(targetBoard.getCreatedAt())
                .id(targetBoard.getId())
                .build();
    }


}
