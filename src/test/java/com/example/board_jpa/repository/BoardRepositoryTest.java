package com.example.board_jpa.repository;

import com.example.board_jpa.model.entity.Board;
import com.example.board_jpa.model.entity.UserEntity;
import com.example.board_jpa.model.response.BoardResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/*
 * 게시글 목록
 *   게시글 제목, 등록일시, 작성자 정보 필요
 *   상태코드 활성화만 조회
 *
 * 게시글 상세
 *   게시글 제목, 내용, 등록일시, 작성자 정보 필요
 *   상태코드 활성화만 조회
 * */

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void deleteAll() {
        boardRepository.deleteAll();
        boardRepository.flush();
    }

    @DisplayName("게시글 목록 전체 조회 테스트")
    @Test
    void findAllBoardTest() {
        // save user
        UserEntity user = UserEntity.builder()
                .userId("tester")
                .password("pwd1234")
                .build();

        userRepository.saveAndFlush(user);

        // save board
        Board board = Board.builder()
                .title("test")
                .content("test content")
                .boardStatusCode("ACTIVATE")
                .userId(user)
                .build();

        boardRepository.saveAndFlush(board);
        List<Board> boardList = boardRepository.findAll();
        System.out.println(boardList);

        assertTrue(boardList.size() == 1);
    }

    @DisplayName("ACTIVATE 게시글 목록 전체 조회 테스트")
    @Test
    void findBoardListByStatusCode() {
        // save user
        UserEntity user = UserEntity.builder()
                .userId("tester")
                .password("pwd1234")
                .build();

        userRepository.saveAndFlush(user);

        // save board
        Board board = Board.builder()
                .title("test")
                .content("test content")
                .boardStatusCode("ACTIVATE")
                .userId(user)
                .build();

        boardRepository.saveAndFlush(board);
        List<Board> boardList = boardRepository.findBoardsByBoardStatusCode("ACTIVATE");
        System.out.println(boardList);

        assertTrue(boardList.get(0).getBoardStatusCode().equals("ACTIVATE"));
    }

    @DisplayName("ACTIVATE 게시글 목록 전체 조회 및 DTO 변환 테스트")
    @Test
    void findBoardListByStatusCodeToBoardListResponse() {
        // save user
        UserEntity user = UserEntity.builder()
                .userId("tester")
                .password("pwd1234")
                .build();

        userRepository.saveAndFlush(user);

        // save board
        Board board = Board.builder()
                .title("test")
                .content("test content")
                .boardStatusCode("ACTIVATE")
                .userId(user)
                .build();

        boardRepository.saveAndFlush(board);
        List<Board> boardList = boardRepository.findBoardsByBoardStatusCode("ACTIVATE");
        System.out.println(boardList);

        List<BoardResponse> boardListResponses = boardRepository.findBoardsByBoardStatusCode("ACTIVATE").stream()
                .map(boardItem -> BoardResponse.builder()
                        .title(boardItem.getTitle())
                        .userId(boardItem.getUserId().getUserId())
                        .regDate(boardItem.getRegDate())
                        .build())
                .collect(Collectors.toList());

//        for(Board boardItem : boardList) {
//            BoardResponse res = BoardResponse.builder()
//                    .title(boardItem.getTitle())
//                    .userId(boardItem.getUserId().getUserId())
//                    .regDate(boardItem.getRegDate())
//                    .build();
//        }

        assertTrue(boardList.get(0).getBoardStatusCode().equals("ACTIVATE"));
    }

    @DisplayName("게시글 생성 테스트")
    @Test
    void saveBoardTest() {
        // save user
        UserEntity user = UserEntity.builder()
                .userId("tester")
                .password("pwd1234")
                .build();

        userRepository.saveAndFlush(user);

        // save board
        Board board = Board.builder()
                .title("test")
                .content("test content")
                .boardStatusCode("ACTIVATE")
                .userId(user)
                .build();

        boardRepository.saveAndFlush(board);
        List<Board> boardList = boardRepository.findBoardsByBoardStatusCode("ACTIVATE");
        assertNotNull(boardList);
        assertEquals(boardList.size(), 1);
    }

    @DisplayName("게시글 수정 테스트")
    @Test
    void updateBoardTest() {
        // save user
        UserEntity user = UserEntity.builder()
                .userId("tester")
                .password("pwd1234")
                .build();

        userRepository.saveAndFlush(user);

        // save board
        Board board = Board.builder()
                .title("test")
                .content("test content")
                .boardStatusCode("ACTIVATE")
                .userId(user)
                .build();

        boardRepository.saveAndFlush(board);
        List<Board> boardList = boardRepository.findBoardsByBoardStatusCode("ACTIVATE");
        assertNotNull(boardList);
        assertEquals(boardList.size(), 1);

        Board updateBoard = board.toBuilder()
                .title("update title")
                .content("update content")
                .build();

        // update board
        boardRepository.saveAndFlush(updateBoard);

        // find updated board
        Optional<Board> updatedBoard = boardRepository.findById(board.getId());

        // assert
        assertEquals(updateBoard.getTitle(), updatedBoard.get().getTitle());
        assertEquals(updateBoard.getContent(), updatedBoard.get().getContent());
    }

    @DisplayName("게시글 삭제 테스트")
    @Test
    void deleteBoardTest() {
// save user
        UserEntity user = UserEntity.builder()
                .userId("tester")
                .password("pwd1234")
                .build();

        userRepository.saveAndFlush(user);

        // save board
        Board board = Board.builder()
                .title("test")
                .content("test content")
                .boardStatusCode("ACTIVATE")
                .userId(user)
                .build();

        boardRepository.saveAndFlush(board);
        List<Board> boardList = boardRepository.findBoardsByBoardStatusCode("ACTIVATE");
        assertNotNull(boardList);
        assertEquals(boardList.size(), 1);

        // delete
        boardRepository.deleteById(board.getId());
        assertEquals(0, boardRepository.findBoardsByBoardStatusCode("ACTIVATE").size());
    }
}