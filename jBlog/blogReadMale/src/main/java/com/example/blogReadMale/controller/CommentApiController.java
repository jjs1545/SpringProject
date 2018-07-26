package com.example.blogReadMale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.blogReadMale.services.CommentService;
import com.example.blogReadMale.vo.CommentVo;
import com.example.blogReadMale.vo.UserVo;

@Controller
@RequestMapping("/comment")
public class CommentApiController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(@ModelAttribute CommentVo vo, Model model, HttpSession session,
			@RequestParam("userName") String name, @RequestParam("content") String content, @RequestParam("post_no") int post_no) {
		
		Map<String, Object> map = new HashMap<>();;
		
		//유저 마다 댓글 삭제버튼을 생성하기위해 세션을 활용한다 
		UserVo uvo = (UserVo)session.getAttribute("authUser");
		
		//서비스 측에 insert를 요청
		vo.setName(name);
		vo.setContent(content);
		vo.setPost_no(post_no);
		
		try {
			
			boolean result = commentService.insert(vo);
			/*포스트 마다의 댓글을 가져온다*/
			List<CommentVo> list = commentService.list(post_no);
			
			map.put("commentList", list);
			map.put("authUser", uvo);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(@ModelAttribute CommentVo vo, Model model, HttpSession session,
			@RequestParam("userName") String name, @RequestParam("content") String content, 
			@RequestParam("post_no") int post_no, @RequestParam("comment_no") int cNo) {
		
		UserVo uvo = (UserVo)session.getAttribute("authUser");
		Map<String, Object> map = new HashMap<>();
		
		System.out.println("cNo:" +cNo);		//댓글 번호
		
		try {
			boolean result = commentService.delete(cNo);
			
			/*포스트 마다의 댓글을 가져온다*/
			List<CommentVo> list = commentService.list(post_no);
			
			map.put("commentList", list);
			map.put("authUser", uvo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
}
