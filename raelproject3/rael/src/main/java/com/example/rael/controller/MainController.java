package com.example.rael.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.rael.dto.SearchDTO;
import com.example.rael.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;

	@RequestMapping("/")
	public ModelAndView Main() {
		ModelAndView mv = new ModelAndView();
		List<String> categorynums = productService.SelectCategoryNums();
		
		SearchDTO searchDTO = new SearchDTO();
		mv.addObject("page",searchDTO.getPage());
		mv.addObject("pageSize",searchDTO.getPageSize());
		mv.addObject("recordSize",searchDTO.getRecordSize());
		mv.addObject("categorynums", categorynums);
		
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login");
		return mv;
	}
	
}
