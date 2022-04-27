package com.study.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.service.PersonService;

public class PersonApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		
		PersonService service=(PersonService) ctx.getBean("person");
		//System.out.println(service.insertPerson("kang", "강민섭"));
		
		System.out.println(service.updatePerson("kang", "강준섭")?"수정성공":"수정실패");
		System.out.println(service.deletePerson("hong1234"));
		System.out.println(service.selectPerson("hong1234"));
	}

}
