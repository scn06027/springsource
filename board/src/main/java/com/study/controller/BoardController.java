package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;
import com.study.dto.PageDTO;
import com.study.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService service;
	// /board/list 
	
	@GetMapping("/list")
	public void listget(Model model,@ModelAttribute("cri") Criteria cri) {
		log.info("전체 리스트 호출!");
		List<BoardDTO> list= service.getList(cri);
		//전체 게시글 개수 
		int total=service.getTotalCnt();
		model.addAttribute("pageDto",new PageDTO(cri, total));
		model.addAttribute("list", list);
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("글쓰기창 호출");
	}
	
	//register post형식인거
	
	@PostMapping("/register")
	public String registerPost(BoardDTO insertDto,RedirectAttributes rttr) {
		log.info("글 등록 요청"+insertDto);
		if(service.insert(insertDto)) {
			rttr.addFlashAttribute("result",insertDto.getBno());
			return "redirect:/board/list";
		}
		
		return "redirect:/board/register";
	}
	
	//bno에 해당하는 게시물 읽어온 후 read.jsp 보여주기
	
	@GetMapping({"/read","/modify"}) //이런방법도 있구나...................
	public void readGet(int bno,Model model) {
		log.info("read 페이지 요청");
		
		BoardDTO selectDto=service.selectList(bno);
		model.addAttribute("selectDto",selectDto);
		
	}
											//알아서 DTO 객체로 받아주니까 !
	@PostMapping("/modify")					//생각해보니까 얘네를 따로따로 안받고 한꺼번에 DTO로 받아줘도 됨...
	public String modifyPost(int bno,String title,String content) {
		log.info("수정요청 : "+bno+title+content);
		if(service.update(bno, title, content)) {
			
			return "redirect:/board/read?bno="+bno;
		}
		return "redirect:/board/modify?bno="+bno;
	}
	
	/*
	 * service.update(bno,title,content)
	 * RedirectAttributes rttr 을 넣어준다음에
	 * rttr.addAttribute("bno",bno);를 해서 보내줘도 된다
	 * return "redirect:/board/read";
	 * */
	@GetMapping("/remove")
	public String remove(int bno,RedirectAttributes rttr) {
		log.info("게시글 삭제"+bno);
		
		service.delete(bno);//실패할일 없으니까 이프문 안써줌!!
		
		rttr.addFlashAttribute("result","success");
		return "redirect:/board/list";
	}
}
