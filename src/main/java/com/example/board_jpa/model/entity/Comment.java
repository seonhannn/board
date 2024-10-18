package com.example.board_jpa.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Long commentId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(nullable = false)
    private String content;

    private String statusCode;

    @Builder.Default
    private LocalDateTime regDate = LocalDateTime.now();

    private String regId;

    private LocalDateTime upDate;

    private String upId;
}
