package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.BookDTO;
import com.study.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/book/*")
public class BookController {
		@Autowired
		private BookService service;
		//전체리스트 출력
		@GetMapping("/list")
		public void list(Model model) {
			log.info("도서 전체 목록 요청");
		//서비스 호출	
			List<BookDTO> list=service.getList();
		//list 담기
		model.addAttribute("list", list);
		}
		
		//도서입력폼 보여주기
		@GetMapping("/insert")
		public void insertGet() {
			log.info("도서 입력 폼");
			//서비스 호출
			//service.bookInsert();
		}
		
		//도서입력요청 처리
		@PostMapping("/insert")
		public String insertPost(BookDTO insertDto,RedirectAttributes rttr) {
			log.info("도서입력요청처리"	+insertDto);
			try {
				if(service.bookInsert(insertDto)) {
				return "redirect:/book/list";
				}
			
			} catch (Exception e) {
				rttr.addFlashAttribute("error","코드를 확인하세요.");
				return "redirect:/book/insert";
			}
			
			
			return "/book/insert";
		}
		
		//도서 삭제 폼 요청(delete.jsp 보여주기)
		@GetMapping("/delete")
		public void deleteGet() {
			log.info("delete 요청");
		}
		
		@PostMapping("/delete")
		public String deletePost(int code) {
			log.info("delete 서비스 요청");
			if(service.bookDelete(code)) {
				return "redirect:/book/list";
			}
			return "/book/delete";
		}
		
		//도서업데이트
		@GetMapping("/update")
		public void updateGet() {
			log.info("업데이트 페이지");
		}
		
		@PostMapping("/update")
		public String UpdatePost(int code,int price) {
			log.info("delete 서비스 요청");
			if(service.bookUpdate(code,price)) {
				return "redirect:/book/list";
			}
			return "/book/update";	
		}
		
		//도서검색
		
		@GetMapping("/search")
		public void Search() {
			
		}
		
		public String SearchPost(String criteria,String keyword,Model model) {
			
			List<BookDTO> list=service.getSearchList(criteria, keyword);
			
			return "/book/update";	
		}
}
