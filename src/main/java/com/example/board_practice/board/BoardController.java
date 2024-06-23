package com.example.board_practice.board;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    BoardService boardService;

    @GetMapping()
    List<ResponseDto> getBoardList() {
        return boardService.findBoardList();
    }

    @GetMapping("/{id}")
    ResponseDto getBoardDetail(@PathVariable("id") Integer id) {
        return boardService.findBoardById(id);
    }

    @PostMapping()
    ResponseEntity<BoardEntity> postBoard(@RequestBody @Valid RequestEntity requestEntity) {
        BoardEntity createdBoard = boardService.saveBoard(requestEntity);

        return org.springframework.http.ResponseEntity.ok(createdBoard);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteBoard(@PathVariable("id") Integer id) {
        boardService.deleteBoard(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity patchBoard(@PathVariable("id") Integer id, @RequestBody @Valid RequestEntity boardRequest) {
        BoardEntity updatedBoard = boardService.updateBoard(id, boardRequest);

        return ResponseEntity.ok(updatedBoard);
    }
}
