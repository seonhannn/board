package com.example.board_jpa.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @Column(unique = true, nullable = false, length = 100)
    private String userId;

    @Column(nullable = false, length = 500)
    private String password;

    @Column(nullable = true)
    private String refreshToken;

    @Column(nullable = true)
    private String userStatusCode;

    @Column(nullable = true)
    private String regDate;

    @Column(nullable = true)
    private String regId;

    @Column(nullable = true)
    private String upDate;

    @Column(nullable = true)
    private String upId;
}
