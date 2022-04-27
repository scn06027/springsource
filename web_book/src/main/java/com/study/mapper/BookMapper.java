package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.dto.BookDTO;

public interface BookMapper {
	//CRUD 작업에 메소드 선언
	
	//삽입
	public int insert(BookDTO insertDto);
	//전체조회, 한개 조회, 검색
	public List<BookDTO> list();
	public BookDTO select(int code);
	public List<BookDTO> search(@Param("criteria") String criteria,@Param("keyword") String keyword);
	//수정
	public int update(@Param("code") int code,@Param("price") int price);
	//삭제
	public int delete(int code);
}
