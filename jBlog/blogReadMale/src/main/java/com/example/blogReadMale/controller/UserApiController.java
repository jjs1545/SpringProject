package com.example.blogReadMale.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.blogReadMale.services.UserService;
import com.example.blogReadMale.vo.UserVo;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserApiController {
	@Autowired
	private UserService userService;
	/**
	 * 로그인 액션
	 * 
	 * */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Object loginAction(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		
		try {

			UserVo authUser = userService.getUserByIdAndPassword(id,password);
			
			if(authUser != null) {
				session.setAttribute("authUser", authUser);
				map.put("result", true);
				return map;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		map.put("result", false);
		return map;
	}
	
	
}
