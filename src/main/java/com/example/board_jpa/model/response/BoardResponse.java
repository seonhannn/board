package com.example.board_jpa.model.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardResponse {
    private String title;
    private String userId;
    private LocalDateTime regDate;
}
