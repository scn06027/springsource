package com.study.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PageDTO {
//page 나누기 정보
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	//전체 게시물 수
	private int total;
	private Criteria cri; //Criteria class에 들어가있는 애들 다 여기에 있따!
	
	public PageDTO(Criteria cri,int total) {
		this.total=total;
		this.cri=cri;
		
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		// 말그대로 페이지수! 10페이지 20페이지 30페이지 이런거
		
		this.startPage=this.endPage-9;
		// 이것도 마찬가지! 
		
		int realEnd=(int)(Math.ceil((total/1.0)/cri.getAmount()));
		if(realEnd<this.endPage) {
			this.endPage=realEnd;
		}
		this.prev=this.startPage>1;
		this.next=this.endPage<realEnd;
	}
}
