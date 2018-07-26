/**
 * 회원가입 & 로그인 컨트롤러
 * 
 * */
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

import com.example.blogReadMale.security.Auth;
import com.example.blogReadMale.services.BlogService;
import com.example.blogReadMale.services.CategoryService;
import com.example.blogReadMale.services.UserService;
import com.example.blogReadMale.vo.BlogVo;
import com.example.blogReadMale.vo.CategoryVo;
import com.example.blogReadMale.vo.UserVo;
import com.fasterxml.jackson.core.JsonParser;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 회원가입 폼
	 * 
	 * */
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo) {
		return "user/joinForm";
	}
	
	/**
	 * 회원가입
	 * 
	 * */
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(@ModelAttribute @Valid UserVo vo, @ModelAttribute BlogVo vo2, Model model,@ModelAttribute CategoryVo cvo) {
		try {
			boolean result = userService.join(vo);
		
			System.out.println("no: "+vo.getNo());
			Long usersNo = vo.getNo();
			int num = (int)(long)usersNo;
			vo2.setUSERS_NO(num);
			vo2.setTitle(vo.getName());
			
			vo2.setTitle(vo.getName());					/*select key 활용 UserNo을 추가한다*/
			boolean result2 = blogService.insert(vo2);		/* 개인 블로그 생성*/
			
			cvo.setBlog_no(num); cvo.setName("미분류"); cvo.setDescription("미분류 카테고리");     					/*미분류 카테고리 생성*/
			boolean result3 = categoryService.insert(cvo);
			
		} catch(Exception e) {
			e.printStackTrace();
			return "errors/exception";
		}
		//model.addAttribute("id",vo.getId());
		return "redirect:/user/joinsuccess";
	}
	
	/**
	 * 회원 가입 성공 페이지
	 * 
	 * */
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess(BlogVo vo) {
		return "user/joinsuccess";
	}
	
	/**
	 * 로그인 페이지
	 * 
	 * */
	@RequestMapping("/login")
	public String login() {
		return "user/loginForm";
	}
	
	/**
	 * 로그인 액션
	 * 
	 * */
	/*@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session) {
		
		try {
			UserVo authUser = userService.getUserByIdAndPassword(id,password);
			
			if(authUser != null) {
				session.setAttribute("authUser", authUser);
				return "redirect:/main";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "errors/exception";
		}
		return "redirect:/login";
	}*/
	
	/**
	 * 마이페이지 폼
	 * 
	 * */
	@Auth
	@RequestMapping("/modify")
	public String MyPage(HttpSession session, Model model) {
		try {
			UserVo vo = (UserVo)session.getAttribute("authUser");
			
			int idx = (int)(long)vo.getNo();
			
			//회원 정보 가져오기
			UserVo uvo = (UserVo)userService.getUserInfo2(idx);
			model.addAttribute("user", uvo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "user/myPage";
	}
	
	
	/**
	 * 마이페이지 회원 정보 수정
	 * 
	 * */
	@Auth
	@RequestMapping("/modify/action")
	public String MyPageUpdate(@ModelAttribute UserVo vo, Model model, 
			@RequestParam("name") String name,@RequestParam("password") String password, @RequestParam("user_no") int uno, HttpSession session) {
		
		System.out.println("name:"+name);
		System.out.println("password:"+password);
		
		//유저 업데이트
		try {
			long num = (int)(long)uno;
			vo.setNo(num);
			boolean result = userService.update(vo);		//회원정보 수정
			
			//회원 정보 가져오기
			UserVo uvo = (UserVo)userService.getUserInfo2(uno);
			model.addAttribute("user", uvo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/modify";
	}
	
	
	/**
	 * 로그아웃
	 * 
	 * */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
