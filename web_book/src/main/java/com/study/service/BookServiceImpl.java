package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.BookDTO;
import com.study.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper mapper;

	@Override
	public boolean bookInsert(BookDTO insertDto) {
		// TODO Auto-generated method stub
		return mapper.insert(insertDto)==1?true:false;
	}

	@Override
	public List<BookDTO> getList() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public BookDTO getRow(int code) {
		// TODO Auto-generated method stub
		return mapper.select(code);
	}

	@Override
	public List<BookDTO> getSearchList(String criteria, String keyword) {
		// TODO Auto-generated method stub
		return mapper.search(criteria,keyword);
	}

	@Override
	public boolean bookUpdate(int code, int price) {
		// TODO Auto-generated method stub
		return mapper.update(code, price)==1?true:false;
	}

	@Override
	public boolean bookDelete(int code) {
		// TODO Auto-generated method stub
		return mapper.delete(code)==1?true:false;
	}

}
