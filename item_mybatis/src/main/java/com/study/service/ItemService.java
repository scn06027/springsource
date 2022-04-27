package com.study.service;

import java.util.List;

import com.study.dto.ItemDTO;

public interface ItemService {
	//CRUD 호출
	public boolean insert(ItemDTO insertDto);
	public ItemDTO selectList(int num);
	public boolean delete(int num);
	public boolean update(int num,String psize,int price);
	public List<ItemDTO> getList();
}
