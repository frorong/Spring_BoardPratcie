package com.example.board_practice.board;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name="board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="title", nullable=false)
    private String title;
    @Column(name="content", nullable=false)
    private String content;
    @Column(name="createdAt", nullable=false)
    private LocalDateTime createdAt;
}
