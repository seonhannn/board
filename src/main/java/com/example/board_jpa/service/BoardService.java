package com.example.board_jpa.service;

import com.example.board_jpa.model.entity.Board;
import com.example.board_jpa.model.response.BoardResponse;

import java.util.List;

/*
 * 게시글 목록
 *   게시글 제목, 등록일시, 작성자 정보 조회
 *   상태코드 활성화만 조회
 *
 * 게시글 상세
 *   게시글 제목, 내용, 등록일시, 작성자 정보 조회
 *   상태코드 활성화만 조회
 * */
public interface BoardService {
    List<BoardResponse> findBoardListByStatusCode(String boardStatusCode);
    Board findBoardById(Long id);
    void saveBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Long id);
}
