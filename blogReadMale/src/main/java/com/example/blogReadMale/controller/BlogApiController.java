package com.example.blogReadMale.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.blogReadMale.vo.CategoryVo;

@Controller
public class BlogApiController {
	@RequestMapping("/category/write")
	public Object writeAction(@ModelAttribute CategoryVo vo, HttpSession session) {
		
		return null;
	}
}
