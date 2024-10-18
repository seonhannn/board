package com.example.board_jpa.controller;

import com.example.board_jpa.model.response.BoardResponse;
import com.example.board_jpa.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/boards")
@RestController
public class BoardController {

    @Autowired
    private BoardServiceImpl boardService;

    @GetMapping
    List<BoardResponse> findBoards() {
        String boardStatusCode = "ACTIVATE";
        return  boardService.findBoardsByStatusCode(boardStatusCode);
    }
}
