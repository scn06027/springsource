package com.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/sample/*")   // http://localhost:9090/sample/**
public class SampleController {
	
	// 앞쪽 고정 : /WEB-INF/views
	// 뒤쪽 고정 : .jsp
	
	//  컨트롤러의 리턴 타입이 void 인 경우
	//  http://localhost:9090/ 다음 부분이 jsp 페이지를 찾는데 사용됨

	//  컨트롤러의 리턴 타입이 String 인 경우
	//  return 값 만을 가지고 jsp 페이지를 찾음
	

	//@RequestMapping(path = "/basic", method = RequestMethod.GET) // http://localhost:9090/sample/basic
	@GetMapping("/basic")
	public void basic(@ModelAttribute("page") int page,Model model) {
		
		log.info("basic...."); // WEB-INF/views/sample/basic.jsp		
		
		//page 변수값을 jsp에서 보여주고싶다.
		//model.addAttribute("page", page);
	}
	
	
	// @RequestMapping("/login") : GET + POST 둘 다 허용
	// @RequestMapping(path = "/login", method = RequestMethod.GET) : GET 허용
	
	//@RequestMapping(path = "/login", method = RequestMethod.GET) //  http://localhost:9090/sample/login

	
	// Controller 파라미터 수집
	// ① 변수 사용
	// ② ~DTO 객체 사용 (jsp에서 값이 유지된다! 1번은 유지가 안된다 ㅇㅇ)
	// ③ HttpServletRequest 객체 사용(필요할 경우만-대부분 사용 잘 안 함)
	
	
	//  @RequestParam("이름") : 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른 경우 사용 

	
	
	
	
//	@RequestMapping(path = "/doA", method=RequestMethod.GET)  // http://localhost:9090/sample/doA
	@GetMapping("/doA")
	public void doA(String userid) {
		log.info("doA..."+userid);  //     WEB-INF/views/sample/doA.jsp
	}
	
	
	
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)  // http://localhost:9090/sample/insert
	@GetMapping("/insert")
	public String insert(@RequestParam("ids") ArrayList<String> ids) {
		log.info("insert..."+ids);
		return "insert";   //    /WEB-INF/views/insert.jsp
	}
}











