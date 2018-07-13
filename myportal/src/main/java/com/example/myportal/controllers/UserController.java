package com.example.myportal.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.myportal.service.UserService;
import com.example.myportal.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute UserVo vo) {
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(@ModelAttribute @Valid UserVo vo, BindingResult bResult, Model model) {
		// TODO: Validation
		if(bResult.hasErrors()) {
			List<ObjectError> errors = bResult.getAllErrors();
			for(ObjectError e:errors) {
				System.out.println("ObjectError: " + e);
			}
			model.addAllAttributes(bResult.getModel());
			return "user/join";
		}
		/*if(vo.getName() == null || vo.getName().length() ==0) {
			return "redirect:/user/join";
		}
`		*/
		boolean result = userService.join(vo);
		
		//TODO: 오류 처리
		return "redirect:/user/joinsuccess";
	}
	@RequestMapping("joinsuccess")
	public String joinSuccess() {
		return "user/joinsuccess";
	}
	
	//로그인 폼
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm() {
		return "user/loginForm";
	}
	
	//로그인 설정
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		UserVo authUser = userService.getUserByEmailAndPassword(email,password);
		
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else {	//is null
			return "redirect:/user/login";
		}
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";		
		
		/**
		  *		form이름을 넣었을 때 데이터를 넣기 위해서 매핑시킨다 -> redirect 사용	
		  *		컨트롤러에서 처리를 했을때 jsp에서 처리 후 브라우저로 제어권을 넘긴다 -> forward
		  *		클라이언트에서 서버측으로 요청을 넘겼을때 특정 내용을 처리하고 다시 응답을 넘길때 브라우저에 보낸다.
		  *
		  *  	forward -> 제어권을 jsp에 넘긴다
		  *  	redirect-> 제어권을 브라우저(클라이언트)에 넘긴다.
		  * 
		  * */
	}
	
	//@EmailCheck
	@RequestMapping("/checkemail")
	@ResponseBody
	public Object exists(@RequestParam("email")String email) {
		boolean exists = userService.exists(email);
		
		Map<String, Object> map = new HashMap<>();
		map.put("result","success");
		map.put("data", exists);
		
		return map;
	}
}
