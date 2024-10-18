package com.example.board_jpa.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardRequest {
    private String title;
    private String content;
    private LocalDateTime currentDate;
}
