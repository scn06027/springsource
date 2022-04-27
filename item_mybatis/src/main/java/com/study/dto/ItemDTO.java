package com.study.dto;

import lombok.Getter;


public class ItemDTO {
	private int num;
	private String category;
	private String name;
	private String content;
	private String psize;
	private int price;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ItemDTO(int num, String category, String name, String content, String psize, int price) {
		super();
		this.num = num;
		this.category = category;
		this.name = name;
		this.content = content;
		this.psize = psize;
		this.price = price;
	}
	@Override
	public String toString() {
		return "ItemDTO [num=" + num + ", category=" + category + ", name=" + name + ", content=" + content + ", psize="
				+ psize + ", price=" + price + "]";
	}
	public ItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
