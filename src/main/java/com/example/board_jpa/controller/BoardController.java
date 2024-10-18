package com.example.board_jpa.controller;

import com.example.board_jpa.model.entity.Board;
import com.example.board_jpa.model.response.BoardResponse;
import com.example.board_jpa.service.BoardService;
import com.example.board_jpa.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RequestMapping("/api/boards")
@RestController
public class BoardController {

    @Autowired
    private BoardServiceImpl boardService;

    @GetMapping
    List<BoardResponse> findBoardList() {
        String boardStatusCode = "ACTIVATE";
        return  boardService.findBoardListByStatusCode(boardStatusCode);
    }
}
