package com.example.board_practice.board;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;
    BoardServiece boardServiece;

    @GetMapping("/list")
    List<ResponseEntity> getBoardList() {
        return boardServiece.findBoardList();
    }

    @GetMapping("/{id}")
    ResponseEntity getBoardDetail(@PathVariable("id") Integer id) {
        return boardServiece.findBoardById(id);
    }

    @PostMapping("/create")
    org.springframework.http.ResponseEntity postCreateBoard(@RequestBody @Valid RequestEntity board) {
        BoardEntity newBoard = new BoardEntity(board.getTitle(), board.getContent());

        boardRepository.save(newBoard);

        return org.springframework.http.ResponseEntity.ok(newBoard);
    }

    @DeleteMapping("/delete/{id}")
    org.springframework.http.ResponseEntity deleteBoard(@PathVariable("id") Integer id) {
        boardRepository.deleteById(id);

        return org.springframework.http.ResponseEntity.ok().build();
    }

    @PatchMapping("/update/{id}")
    @Transactional
    org.springframework.http.ResponseEntity updateBoard(@PathVariable("id") Integer id, @RequestBody @Valid RequestEntity boardRequest) {
        Optional<BoardEntity> targetBoardEntity = boardRepository.findById(id);

        if (targetBoardEntity.isEmpty()) {
            return org.springframework.http.ResponseEntity.status(HttpStatus.NOT_FOUND).body("Board not found");
        }

        BoardEntity boardEntity = targetBoardEntity.get();

        boardEntity.setTitle(boardRequest.getTitle());
        boardEntity.setContent(boardRequest.getContent());

        boardRepository.save(boardEntity);

        return org.springframework.http.ResponseEntity.ok(boardEntity);
    }
}
