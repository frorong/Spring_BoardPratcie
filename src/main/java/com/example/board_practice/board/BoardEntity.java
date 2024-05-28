package com.example.board_practice.board;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    @Column(name = "title", nullable = false)
    private String title;
    @Setter
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public BoardEntity(String title, String content) {
        Assert.hasText(title, "Title cannot be empty");
        Assert.hasText(content, "Content cannot be empty");
        
        this.title = title;
        this.content = content;
    }
}
