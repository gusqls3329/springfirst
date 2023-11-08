package com.green.springfirst.board;

import com.green.springfirst.board.model.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor  // BoardService의 객체주소값이 아래의 service에 들어감,유일해야함(선택해야하는것은 사용하지 못함)
public class BoardController {
    private final BoardService service;
    @GetMapping("/board") // url연결해줌
    public List<BoardVo> getBoard(){
    return service.getBoard();
    }
}
