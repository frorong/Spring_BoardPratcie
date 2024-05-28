package com.example.board_practice.board;

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
    BoardServiece boardServiece;

    @GetMapping()
    List<ResponseEntity> getBoardList() {
        return boardServiece.findBoardList();
    }

    @GetMapping("/{id}")
    ResponseEntity getBoardDetail(@PathVariable("id") Integer id) {
        return boardServiece.findBoardById(id);
    }

    @PostMapping()
    org.springframework.http.ResponseEntity postBoard(@RequestBody @Valid RequestEntity requestEntity) {
        BoardEntity createdBoard = boardServiece.saveBoard(requestEntity);

        return org.springframework.http.ResponseEntity.ok(createdBoard);
    }

    @DeleteMapping("/{id}")
    org.springframework.http.ResponseEntity deleteBoard(@PathVariable("id") Integer id) {
        boardServiece.deleteBoard(id);

        return org.springframework.http.ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    org.springframework.http.ResponseEntity updateBoard(@PathVariable("id") Integer id, @RequestBody @Valid RequestEntity boardRequest) {
        Optional<BoardEntity> updatedBoard = boardServiece.updateBoard(id, boardRequest);

        if (updatedBoard.isEmpty()) {
            return org.springframework.http.ResponseEntity.status(HttpStatus.NOT_FOUND).body("Board not found");
        }

        return org.springframework.http.ResponseEntity.ok(updatedBoard);
    }
}
