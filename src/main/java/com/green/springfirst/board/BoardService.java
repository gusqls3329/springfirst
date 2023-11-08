package com.green.springfirst.board;

import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
// @Component : 빈등록 이거 외 다른 빈등록은 다른 기능도 가지고 있따.
@Service //빈등록 + 로직담당
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;
    /*@Autowired
    public BoardService(BoardMapper mapper){
        this.mapper = mapper;
    }*/
    public List<BoardVo> getBoard(){
        return mapper.selBoardList();
    }

    BoardDetailVo selBoardById(int iboard){
        return mapper.selBoardById(iboard);
    }
}

/*
방법1 = 방법2
방법1 : 주소값을 직접 주입받는 방법 : 제대로 작동하는지 파악이 어렵기 때문에 비추
@Service
public class BoardService {
    private final BoardMapper mapper;
    @Autowired
    public BoardService(BoardMapper mapper){
        this.mapper = mapper;
    }
    public List<BoardVo> getBoard(){
        return mapper.selBoardList();
    }
}
방법2 : 생성자를 통해서 주입받는 방법
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;
public List<BoardVo> getBoard(){
    return mapper.selBoardList();
    }
}
 */