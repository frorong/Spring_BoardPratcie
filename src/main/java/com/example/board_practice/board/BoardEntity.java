package com.example.board_practice.board;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="title", nullable=false)
    private String title;
    @Column(name="content", nullable=false)
    private String content;
    @Column(name="createdAt", nullable=false)
    private LocalDateTime createdAt;
}
