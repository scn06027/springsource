package com.study.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.study.dto.PersonDTO;

import lombok.Getter;


public interface PersonMapper {
	//#{id},#{name}==> ?로 변경됨
	
	/*
	 * @Insert("insert into person(id,name) values(#{id},#{name})") public int
	 * insertPerson(@Param("id") String id, @Param("name")String name); //얘를 물음표에
	 * 못넣어줘가지고 오류뜨고있는거임 인터페이스에서 넘겨줄때 여기가 잘못 넘어가고 있는거임
	 */
	
	public int insert(@Param("id") String id, @Param("name")String name);
	public int update(@Param("id") String id, @Param("name")String name);
	public int delete(String id);
	public PersonDTO select(String id);
}
