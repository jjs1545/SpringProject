/**
 * 카테고리 컨트롤러
 * 
 * */
package com.example.blogReadMale.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.blogReadMale.security.Auth;
import com.example.blogReadMale.services.BlogService;
import com.example.blogReadMale.services.CategoryService;
import com.example.blogReadMale.vo.BlogVo;
import com.example.blogReadMale.vo.CategoryVo;
import com.example.blogReadMale.vo.UserVo;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BlogService blogService;
	
	
	/**
	 * 카테고리 메인
	 * 
	 * */ 
	@Auth
	@RequestMapping("/{id}/admin/category")
	public String MyblogCategory(@PathVariable String id, Model model, HttpSession session) {
		
		try {
			/*session.setAttribute("id", id);*/
			UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
			
			int idx = (int)(long)uvo.getNo();
			
			//특정 유저의 카테고리 리스트
			List<CategoryVo> list = categoryService.getList(idx);
			BlogVo bvo = blogService.getBlogInfo(idx);		//블로그 유저 정보 추가
			
			model.addAttribute("id",id);
			model.addAttribute("vo",bvo);
			model.addAttribute("list", list);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "blog/myBlogPage/category";
		
	}
	
}
