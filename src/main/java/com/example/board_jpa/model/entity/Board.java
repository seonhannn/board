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
@Builder(toBuilder = true)
public class Board {
    @Id
    @GeneratedValue
    private Long boardId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String statusCode;

    private boolean isUser;

    private String password;

    @Builder.Default
    private LocalDateTime regDate = LocalDateTime.now();

    private String regId;

    private LocalDateTime upDate;

    private String upId;
}
