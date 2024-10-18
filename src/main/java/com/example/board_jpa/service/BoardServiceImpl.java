package com.example.board_jpa.service;

import com.example.board_jpa.model.entity.Board;
import com.example.board_jpa.model.response.BoardResponse;
import com.example.board_jpa.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<BoardResponse> findBoardsByStatusCode(String statusCode) {
        return boardRepository.findBoardsByStatusCode(statusCode).stream().map(boardItem -> BoardResponse.builder()
                .title(boardItem.getTitle())
                .userId(boardItem.getUser().getUserId())
                .regDate(boardItem.getRegDate())
                .build()).toList();
    }

    @Override
    public Board findBoardById(Long boardId) {
        return boardRepository.findById(boardId).orElse(null);
    }

    @Override
    public void saveBoard(Board board) {
        boardRepository.saveAndFlush(board);
    }

    @Override
    public void updateBoard(Board updateBoard) {
        Board existingBoard = findBoardById(updateBoard.getBoardId());

        if(!updateBoard.getTitle().isBlank()) {
            existingBoard.setTitle(updateBoard.getTitle());
        }

        if(!updateBoard.getContent().isBlank()) {
            existingBoard.setContent(updateBoard.getContent());
        }

        boardRepository.saveAndFlush(existingBoard);
    }

    @Override
    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
