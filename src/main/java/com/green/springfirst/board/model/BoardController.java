package com.green.springfirst.board.model;

import com.green.springfirst.board.ResVo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Controller : 디폴트 응답값이 hml : 요청받고 응답받는것. hml주는것이 목적
//@AllArgsConstructor : final과 상관없이 외부에서 값을 넣을 수 있는 생성자를 만들어 달라는것
// @NoArgsConstructor : 아규먼트가 없는 기본 생성자를 만들어줌
@RestController //빈등록 + 컨트롤러 :Rest 디폴트가 응답이 제이슨
@RequiredArgsConstructor  // final이 붙은 값을 외부에서받을수 있는 생성자만 만들어지는것// BoardService의 객체주소값이 아래의 service에 들어감,유일해야함(선택해야하는것은 사용하지 못함)
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService service;
    @GetMapping // url연결해줌, "" : 주소값 // select는 많이 보내야하기 때문에 resvo을 사용하지 않음
    public List<BoardVo> getBoard(){
    return service.getBoard();
    }
    @PostMapping ("/{iboard}") // "/board/{iboard}" : ""안은 "주소값+{값}"
    public BoardDetailVo getBoardDetail(@PathVariable int iboard){ //@PathVariable : pk값 Select할때 주로 사용 //받는 글이 2개이상이면 무조건 List를 사용해야함.
        System.out.println(iboard);
        return service.selBoardById(iboard);
    }

    @PutMapping
    public ResVo putBoard(@RequestBody BoardUpdDto dto){ //@RequestBody Body내용(josn형태로 오는 내용을 담기 위해서 사용 ResVo: 0인지 1인지에 따라 성공 여부 확인가능
        System.out.println(dto);
        int result = service.putBoard(dto);
        return new ResVo(result);
    }

   /* @PostMapping("/board") //위와 같은 주소값이라도 post인지 get인지에 따라 가는 곳이 다름 만약 포스트로 하면 PostMapping에 와서 1이 넘어감
    public int postBoard(@RequestBody BoardInsDto dto){
        System.out.println(dto);
        return service.postBoard(dto);

    }*/
   @PostMapping //위와 같은 주소값이라도 post인지 get인지에 따라 가는 곳이 다름 만약 포스트로 하면 PostMapping에 와서 1이 넘어감
   public ResVo postBoard(@RequestBody BoardInsDto dto){
       System.out.println(dto);
       int result = service.postBoard(dto);
       System.out.println("result : "+result);
       return new ResVo(result);
   }
    @DeleteMapping  ("/{iboard}")
    public ResVo delBoard(@PathVariable int iboard){
        System.out.println(iboard);
        int result = service.delBoard(iboard);
        return new ResVo(result);
    }



}//@ReponseBody : 제이슨을 주는것이목적,RequestBody:제이슨으로 들어오는걸 옆에있는 객체 형식을 변경하겠다.
