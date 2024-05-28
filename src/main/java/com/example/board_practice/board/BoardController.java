package com.example.board_practice.board;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    BoardService boardService;

    @GetMapping()
    List<ResponseEntity> getBoardList() {
        return boardService.findBoardList();
    }

    @GetMapping("/{id}")
    ResponseEntity getBoardDetail(@PathVariable("id") Integer id) {
        return boardService.findBoardById(id);
    }

    @PostMapping()
    org.springframework.http.ResponseEntity postBoard(@RequestBody @Valid RequestEntity requestEntity) {
        BoardEntity createdBoard = boardService.saveBoard(requestEntity);

        return org.springframework.http.ResponseEntity.ok(createdBoard);
    }

    @DeleteMapping("/{id}")
    org.springframework.http.ResponseEntity deleteBoard(@PathVariable("id") Integer id) {
        boardService.deleteBoard(id);

        return org.springframework.http.ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    org.springframework.http.ResponseEntity patchBoard(@PathVariable("id") Integer id, @RequestBody @Valid RequestEntity boardRequest) {
        BoardEntity updatedBoard = boardService.updateBoard(id, boardRequest);

        return org.springframework.http.ResponseEntity.ok(updatedBoard);
    }
}
