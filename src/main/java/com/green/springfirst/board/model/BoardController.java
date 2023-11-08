package com.green.springfirst.board.model;

import com.green.springfirst.board.ResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Controller : 디폴트 응답값이 hml : 요청받고 응답받는것.hml주는것이 목적
@RestController //빈등록 + 컨트롤러 :Rest 디폴트가 응답이 제이슨
@RequiredArgsConstructor  // BoardService의 객체주소값이 아래의 service에 들어감,유일해야함(선택해야하는것은 사용하지 못함)
public class BoardController {
    private final BoardService service;
    @GetMapping("/board") // url연결해줌, "" : 주소값
    public List<BoardVo> getBoard(){
    return service.getBoard();
    }
    @PostMapping ("/board/{iboard}") // "/board/{iboard}" : ""안은 "주소값+{값}"
    public BoardDetailVo getBoardDetail(@PathVariable int iboard){ //@PathVariable : pk값 Select할때 주로사용
        System.out.println(iboard);
        return service.selBoardById(iboard);
    }
    @PutMapping("/board")
    public ResVo putBoard(@RequestBody BoardUpdDto dto){
        System.out.println(dto);
        int result = service.putBoard(dto);
        return new ResVo(result);
    }

   /* @PostMapping("/board") //위와 같은 주소값이라도 post인지 get인지에 따라 가는 곳이 다름 만약 포스트로 하면 PostMapping에 와서 1이 넘어감
    public int postBoard(@RequestBody BoardInsDto dto){
        System.out.println(dto);
        return service.postBoard(dto);

    }*/
   @PostMapping("/board") //위와 같은 주소값이라도 post인지 get인지에 따라 가는 곳이 다름 만약 포스트로 하면 PostMapping에 와서 1이 넘어감
   public ResVo postBoard(@RequestBody BoardInsDto dto){
       System.out.println(dto);
       int result = service.postBoard(dto);
       System.out.println("result : "+result);
       return new ResVo(result);
   }
    @DeleteMapping  ("/board/{iboard}")
    public ResVo delBoard(@PathVariable int iboard){
        System.out.println(iboard);
        int result = service.delBoard(iboard);
        return new ResVo(result);
    }



}//@ReponseBody : 제이슨을 주는것이목적,RequestBody:제이슨으로 들어오는걸 옆에있는 객체 형식을 변경하겠다.
