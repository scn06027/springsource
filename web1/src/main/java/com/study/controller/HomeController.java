package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.RegisterDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
				
		return "home";   // /WEB-INF/views/home.jsp
	}
	@GetMapping("/doB")
	public String doB(RedirectAttributes rttr) {
		rttr.addAttribute("age",10);
		rttr.addFlashAttribute("num",15);
		return "redirect:/";	
	}
	
	//예전방식
	@GetMapping("/doC")
	public ModelAndView doC() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home");
		mav.addObject("num",35); //=request.setAttribute()
		return mav;
	}
	
	@GetMapping("doD")
	public RegisterDTO regist() {
		return new RegisterDTO();
	}
}







