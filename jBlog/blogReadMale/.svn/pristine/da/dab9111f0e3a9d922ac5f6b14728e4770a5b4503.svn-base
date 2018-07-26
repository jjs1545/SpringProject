package com.example.blogReadMale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.blogReadMale.services.GuestbookService;
import com.example.blogReadMale.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping({"", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookService.list();
		model.addAttribute("list",list);
		return "guestbook/list";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestbookVo vo) {
		//서비스 측에 insert를 요청
		boolean result = guestbookService.insert(vo);
		return "redirect:/guestbook/list";
	}
}
