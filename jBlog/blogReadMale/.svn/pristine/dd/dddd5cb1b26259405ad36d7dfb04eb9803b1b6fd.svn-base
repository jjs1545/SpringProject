package com.example.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.blog.services.UserService;
import com.example.blog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/join")
	public String join() {
		return "user/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(@ModelAttribute UserVo vo) {
		boolean result = userService.join(vo);
		
		if(result) {
		return "user/join";
		} else {
			return "redirect:/user/join";
		}
	}
	
	@RequestMapping("/login")
	public String login() {
		return "user/loginForm";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction() {
		return "redirect:/";
	}
	
	
}
