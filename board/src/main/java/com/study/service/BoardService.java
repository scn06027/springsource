package com.study.service;

import java.util.List;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;

public interface BoardService {
	public List<BoardDTO> getList(Criteria cri);
	public boolean insert(BoardDTO insertDto);
	public BoardDTO selectList(int bno);
	public boolean update(int bno,String title,String content);
	public boolean delete(int bno);
	public int getTotalCnt();
	}
