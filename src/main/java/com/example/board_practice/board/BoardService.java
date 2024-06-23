package com.example.board_practice.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    List<ResponseDto> findBoardList() {
        List<ResponseDto> responseBoardList = boardRepository.findAll().stream().map(item -> ResponseDto.builder().title(item.getTitle()).content(item.getContent()).createdAt(item.getCreatedAt()).id(item.getId()).build()).collect(Collectors.toList());
        return responseBoardList;
    }

    ResponseDto findBoardById(Integer id) {
        BoardEntity targetBoard = boardRepository.findById(id).orElse(null);

        return ResponseDto.builder()
                .title(targetBoard.getTitle())
                .content(targetBoard.getContent())
                .createdAt(targetBoard.getCreatedAt())
                .id(targetBoard.getId())
                .build();
    }

    BoardEntity saveBoard(RequestEntity requestEntity) {
        BoardEntity newBoard = new BoardEntity(requestEntity.getTitle(), requestEntity.getContent());

        boardRepository.save(newBoard);

        return newBoard;
    }

    void deleteBoard(Integer id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    BoardEntity updateBoard(Integer id, RequestEntity requestEntity) {
        Optional<BoardEntity> targetBoardEntity = boardRepository.findById(id);

        if (targetBoardEntity.isPresent()) {
            BoardEntity newBoard = new BoardEntity(requestEntity.getTitle(), requestEntity.getContent(), id);

            boardRepository.save(newBoard);
            return newBoard;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not Found");
    }
}
