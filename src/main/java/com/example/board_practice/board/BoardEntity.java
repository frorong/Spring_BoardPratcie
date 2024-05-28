package com.example.board_practice.board;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Setter
    @Column(name="title", nullable=false)
    private String title;
    @Setter
    @Column(name="content", nullable=false)
    private String content;
    @Column(name="createdAt", nullable=false)
    private LocalDateTime createdAt = LocalDateTime.now();

    BoardEntity (String title, String content) {
        this.title = title.trim();
        this.content = content.trim();
    }

}
