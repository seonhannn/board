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
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 800)
    private String content;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @Column(nullable = false, length = 50)
    private String boardStatusCode;

    @Builder.Default
    private LocalDateTime regDate = LocalDateTime.now();

    @Column(nullable = true)
    private String regId;

    @Column(nullable = true)
    private LocalDateTime upDate;

    @Column(nullable = true)
    private String upId;
}
