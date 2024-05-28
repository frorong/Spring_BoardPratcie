package com.example.board_practice.board;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    org.springframework.http.ResponseEntity patchBoard(@PathVariable("id") Integer id, @RequestBody @Valid RequestEntity boardRequest) {
        BoardEntity updatedBoard = boardServiece.updateBoard(id, boardRequest);

        return org.springframework.http.ResponseEntity.ok(updatedBoard);
    }
}
