package com.green.springfirst.board;

import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@Controller : 디폴트 응답값이 hml : 요청받고 응답받는것.
@RestController //빈등록 + 컨트롤러 :Rest 디폴트가 응답이 제이슨
@RequiredArgsConstructor  // BoardService의 객체주소값이 아래의 service에 들어감,유일해야함(선택해야하는것은 사용하지 못함)
public class BoardController {
    private final BoardService service;
    @GetMapping("/board") // url연결해줌, "" : 주소값
    public List<BoardVo> getBoard(){
    return service.getBoard();
    }
    @GetMapping("/board/{iboard}")
    public BoardDetailVo getBoardDetail(@PathVariable int iboard){
        System.out.println(iboard);
        return service.selBoardById(iboard);
    }
    @PostMapping("/board") //위와 같은 주소값이라도 post인지 get인지에 따라 가는 곳이 다름 만약 포스트로 하면 PostMapping에 와서 1이 넘어감
    public int insBoard(){
        return 1;
    }
}
