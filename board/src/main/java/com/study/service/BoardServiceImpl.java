package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;
import com.study.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;
	@Override
	public List<BoardDTO> getList(Criteria cri) {
		return mapper.getList(cri);
	}
	@Override
	public boolean insert(BoardDTO insertDto) {
		return mapper.insert(insertDto)==1?true:false;
	}
	@Override
	public BoardDTO selectList(int bno) {
		return mapper.selectList(bno);
	}
	@Override
	public boolean update(int bno, String title, String content) {
		return mapper.update(bno, title, content)==1?true:false;
	}
	@Override
	public boolean delete(int bno) {
		return mapper.delete(bno)==1?true:false;
	}
	@Override
	public int getTotalCnt() {
		return mapper.totalCnt();
	}

}
