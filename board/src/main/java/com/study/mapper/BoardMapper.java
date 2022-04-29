package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;

public interface BoardMapper {
	public List<BoardDTO> getList(Criteria cri);
	public int insert(BoardDTO insertDto);
	public BoardDTO selectList(int bno);
	public int update(@Param("bno") int bno,@Param("title") String title,@Param("content") String content);
	public int delete(int bno);
	public int totalCnt();
}
