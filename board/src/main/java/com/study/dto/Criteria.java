package com.study.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	private int pageNum; //사용자가 선택한 페이지번호
	private int amount; //한페이지당 보여줄게시물개수
	
	private String type; //검색조건
	private String keyword; //검색어
	
	public Criteria() {
		this(1,10); //다른 생성자 호출한다. 저것들에게 1과 10이 들어가도록 ↓ 여기 밑에있는거
	}

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
