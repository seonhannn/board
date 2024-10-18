package com.example.board_jpa.repository;

import com.example.board_jpa.model.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findBoardsByBoardStatusCode(String boardStatusCode);
}
