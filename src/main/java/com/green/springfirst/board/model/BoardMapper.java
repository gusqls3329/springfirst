package com.green.springfirst.board.model;

import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardInsDto;
import com.green.springfirst.board.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/*@Mapper : </>BoardMapper의 mapper namespace="com.green.springfirst.board.BoardMapper의주소를 불러옴
selBoardList와 </>BoardMapper의id는 같아야한다
 */
@Mapper // 빈등록까지 시켜줌 > class파일을 만들어 오버라이딩해서 빈등록까지
public interface BoardMapper {
    int insBoard(BoardInsDto dto);
    List<BoardVo> selBoardList();
    BoardDetailVo selBoardById(int iboard);
    int updBoard(BoardUpdDto dto);
    int delBoard(int iboard);

}
