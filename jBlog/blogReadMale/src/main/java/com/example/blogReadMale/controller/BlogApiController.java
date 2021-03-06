/**
 * Blog Ajax 컨트롤러
 *
 */
package com.example.blogReadMale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.blogReadMale.services.CategoryService;
import com.example.blogReadMale.services.UserService;
import com.example.blogReadMale.vo.CategoryVo;
import com.example.blogReadMale.vo.UserVo;


@Controller
public class BlogApiController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;

	/**
	 * 카테고리 생성
	 *
	 */
	
	@RequestMapping("/category/write")
	@ResponseBody
	public Object writeAction(@RequestParam("cTitle") String cTitle, @RequestParam("explain") String explain, 
			@RequestParam("bno") int bno, @ModelAttribute CategoryVo vo, Model model) {
		
		vo.setBlog_no(bno);
		System.out.println("blogNo:" + vo.getBlog_no());
		vo.setName(cTitle);
		vo.setDescription(explain);
		
		
		boolean result = categoryService.insert(vo); 

		/*블로그 NO를 활용해 해당 블로그의 카테고리만 가져온다*/
		List<CategoryVo> list = categoryService.getList(bno);
		
		Map<String, Object> map = new HashMap<>();
		map.put("data", list);
		
		return map;
	}
	
	/**
	 *  카테고리 삭제 
	 *  
	 */
	
	@RequestMapping(value="/category/delete")
	@ResponseBody
	public Object deleteAction(@RequestParam("cNo") int idx, @ModelAttribute CategoryVo vo, Model model, HttpSession session) {
		
		boolean result = categoryService.delete(idx);
		
		UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
		int blog_no = (int)(long)uvo.getNo();
		
		//유저별 카테고리 출력
		List<CategoryVo> list = categoryService.getList(blog_no);
		
		Map<String, Object> map = new HashMap<>();
		map.put("data", list);
		return map;
	}

	
	/**
	 * 아이디 중복검사
	 * 
	 */
	
	@RequestMapping("/user/checkId")
	@ResponseBody
	public Object exists(@RequestParam("id") String id) {
		boolean exists = userService.getUserById(id);

		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
		
		return map;
	}
}
