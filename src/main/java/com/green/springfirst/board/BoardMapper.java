package com.green.springfirst.board;

import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/*@Mapper : </>BoardMapper의 mapper namespace="com.green.springfirst.board.BoardMapper의주소를 불러옴
selBoardList와 </>BoardMapper의id는 같아야한다
 */
@Mapper // 빈등록
public interface BoardMapper {
    List<BoardVo> selBoardList();
    BoardDetailVo selBoardById(int iboard);
}
