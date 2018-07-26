/**
 * 메인 컨트롤러
 * 
 * */
package com.example.blogReadMale.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.blogReadMale.services.BlogService;
import com.example.blogReadMale.services.CommentService;
import com.example.blogReadMale.services.PostService;
import com.example.blogReadMale.vo.BlogVo;
import com.example.blogReadMale.vo.CommentVo;
import com.example.blogReadMale.vo.PagingVo;
import com.example.blogReadMale.vo.PostVo;

@Controller
public class MainController {
	@Autowired
	private BlogService blogSerivce;
	
	
	@RequestMapping({"/","main"})
	public String hello() {
		return "main/index";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("select") String select, @RequestParam("search") String search,Model model) {
		
		try {
			
			if(select.equals("title")) {
				List<BlogVo> list = blogSerivce.getSearhResult(search);		
				model.addAttribute("list",list);
			}
			else if(select.equals("bloger")) {
				List<BlogVo> list = blogSerivce.getSearhResult2(search);		
				model.addAttribute("list",list);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "main/emptyBlogList";
		}
		return "main/blogList";
	}
	
	/**
	 * 전체 블로그
	 * */
	@RequestMapping("/blog/list")
	public String blogList(Model model) {
		try {
			List<BlogVo> list = blogSerivce.getAllBlogList();
			model.addAttribute("list",list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "main/allBlogList";
	}
}

