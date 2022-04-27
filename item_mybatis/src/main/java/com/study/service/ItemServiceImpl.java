package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.ItemDTO;
import com.study.mapper.ItemMapper;

@Service("service")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public boolean insert(ItemDTO insertDto) {
		return itemMapper.insert(insertDto)==1?true:false;
	}

	@Override
	public ItemDTO selectList(int num) {
		return itemMapper.selectList(num);
		}

	@Override
	public boolean delete(int num) {
		return itemMapper.delete(num)==1?true:false;
		}

	@Override
	public boolean update(int num, String psize, int price) {
		return itemMapper.update(num,psize,price)==1?true:false;
		}

	@Override
	public List<ItemDTO> getList() {
		return itemMapper.getList();
	}

}
