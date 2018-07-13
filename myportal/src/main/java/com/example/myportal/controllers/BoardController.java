package com.example.myportal.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.myportal.security.Auth;
import com.example.myportal.service.BoardService;
import com.example.myportal.vo.BoardVo;
import com.example.myportal.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping({"/","/list"})
	public String list(Model model) {
		// 리스트
		List<BoardVo> list = boardService.getList();
		model.addAttribute("list",list);
		return "board/list";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm() {
		return "board/writeForm";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writeAction(@ModelAttribute BoardVo vo, HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/board";
		}
		vo.setUserNo(authUser.getNo());
		boardService.write(vo);
		return "redirect:/board/list";	//redirect로 브라우저에 요청 redirect가 없을 시 jsp페이지를 불러온다 
		//return "/board/list";
	}
}
