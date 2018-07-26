package com.example.blogReadMale.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.blogReadMale.services.BlogService;
import com.example.blogReadMale.services.UserService;
import com.example.blogReadMale.vo.BlogVo;
import com.example.blogReadMale.vo.UserVo;
import com.fasterxml.jackson.core.JsonParser;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	
	/*회원가입*/
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo) {
		return "user/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(@ModelAttribute @Valid UserVo vo, @ModelAttribute BlogVo vo2, Model model) {
		boolean result = userService.join(vo);
	
		System.out.println("no: "+vo.getNo());
		Long usersNo = vo.getNo();
		int num = (int)(long)usersNo;
		vo2.setUSERS_NO(num);
		vo2.setTitle(vo.getName());
		
/*		vo2.getUSERS_NO();
		System.out.println("getUSERS_NO1:"+vo2.getUSERS_NO());*/
		vo2.setTitle(vo.getName());
		boolean result2 = blogService.insert(vo2);
		
		//model.addAttribute("id",vo.getId());
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess(BlogVo vo) {
		return "user/joinsuccess";
	}
	
	/*로그인*/
	@RequestMapping("/login")
	public String login() {
		return "user/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session) {
		
		UserVo authUser = userService.getUserByIdAndPassword(id,password);
		
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		}

		return "redirect:/login";
	}
	
	/*로그아웃*/
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//Ajax활용한 데이터 교환 -> 아이디 중복검사
	@RequestMapping("/checkId")
	@ResponseBody
	public Object exists(@RequestParam("id") String id) {
		boolean exists = userService.getUserById(id);

		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
		
		/*Map<String, Object> map = new HashMap<>();
		map.put("id",id);*/
		return map;
	}

}
