package com.example.board_practice.board;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @PostMapping("/create")
    ResponseEntity postCreateBoard (@RequestBody @Valid Request board) {
        BoardEntity newBoard = new BoardEntity(board.getTitle(), board.getContent());

        boardRepository.save(newBoard);

        return ResponseEntity.ok(newBoard);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteBoard (@PathVariable("id") Integer id) {
        boardRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update/{id}")
    ResponseEntity updateBoard(@PathVariable("id") Integer id, @RequestBody @Valid Request boardRequest) {
        Optional<BoardEntity> targetBoardEntity = boardRepository.findById(id);

        if (targetBoardEntity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Board not found");
        }

        BoardEntity boardEntity = targetBoardEntity.get();

        boardEntity.setTitle(boardRequest.getTitle());
        boardEntity.setContent(boardRequest.getContent());

        boardRepository.save(boardEntity);

        return ResponseEntity.ok(boardEntity);
    }
}
