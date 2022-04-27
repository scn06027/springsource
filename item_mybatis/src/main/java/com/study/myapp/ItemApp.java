package com.study.myapp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.service.ItemService;

public class ItemApp {
 public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
	
	ItemService service=(ItemService) ctx.getBean("service");
	
	boolean flag=true;
	int num;
	Scanner sc=new Scanner(System.in);
	while(flag) {
		System.out.println("-------------------------");
		System.out.println("1. 아이템 추가");
		System.out.println("2. 아이템 조회");
		System.out.println("3. 아이템 삭제");
		System.out.println("4. 아이템 수정");
		System.out.println("5. 아이템 전체 조회");
		System.out.println("6. 시스템 종료");
		System.out.print("=>    ");
		
		int no=Integer.parseInt(sc.nextLine());
		
		switch (no) {
		case 1:
			System.out.println(service.insert(null));
			break;
		case 2:
			
			break;
		case 3:
			System.out.print("삭제할 번호를 입력해주세요");
			num=Integer.parseInt(sc.nextLine());
			System.out.println(service.delete(num)==true?"삭제성공":"삭제 실패");
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			System.out.println("시스템을 종료합니다.");
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
			break;
		}
	}
 }
}
