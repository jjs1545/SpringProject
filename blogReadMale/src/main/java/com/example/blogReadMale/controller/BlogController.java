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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.blogReadMale.services.BlogService;
import com.example.blogReadMale.services.CategoryService;
import com.example.blogReadMale.services.FileUploadService;
import com.example.blogReadMale.services.UserService;
import com.example.blogReadMale.vo.BlogVo;
import com.example.blogReadMale.vo.CategoryVo;
import com.example.blogReadMale.vo.UserVo;

@Controller
public class BlogController {
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private CategoryService categoryService;
	
	/*@PathVariable*/
	@RequestMapping("/{id}")
	public String blog(@PathVariable String id, Model model) {
		String returnUrl="";
		boolean exists = false;
		
		try {
			//유저가 가입되어 있는지 없는지 여부 판단.
			exists = userService.getUserById(id);
			//유저의 정보를 List로 가져온다
			UserVo uvo = userService.getUserInfo(id);
			int idx = (int)(long)uvo.getNo();
			BlogVo bvo = blogService.getBlogInfo(idx);
			model.addAttribute("vo",bvo);
		}catch (Exception e){
			//TODO 에러발생시 404 처리
			e.printStackTrace();
			return "/errors/exception";
		}
		
		
		
		if(exists==true) {
			returnUrl= "blog/blogMain";
		}
			
		return returnUrl;
	}
	
	@RequestMapping("/blog")
	public String blog() {
		return "blog/blogMain";
	}
	
	@RequestMapping("/{id}/admin/basic")
	public String Myblog(@PathVariable String id, Model model, HttpSession session) {
	
		UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
		int idx = (int)(long)uvo.getNo();
		BlogVo bvo = blogService.getBlogInfo(idx);		//회원가입 순서를 활용해서 유저를 구별한다.
		model.addAttribute("id",id);
		model.addAttribute("vo",bvo);
		
		return "blog/myBlogPage/basic";
	}
	
	@RequestMapping("/{id}/admin/category")
	public String MyblogCategory(@PathVariable String id, Model model, HttpSession session) {
		//리스트
		//List<CategoryVo> list = categoryService.getList();
		
		UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
		
		int idx = (int)(long)uvo.getNo();
		BlogVo bvo = blogService.getBlogInfo(idx);		//블로그 유저 정보 추가
		
		model.addAttribute("id",id);
		model.addAttribute("vo",bvo);
		
		return "blog/myBlogPage/category";
	}
	
	@RequestMapping("/{id}/admin/write")
	public String MyblogWrite(@PathVariable String id, Model model, HttpSession session) {
	
		UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
		/*System.out.println("session:" + uvo.getId());
		System.out.println("session:" + uvo.getNo());*/
		int idx = (int)(long)uvo.getNo();
		/*System.out.println("idx :" +idx);*/
		BlogVo bvo = blogService.getBlogInfo(idx);		//회원가입 순서를 활용해서 유저를 구별한다.
		model.addAttribute("id",id);
		model.addAttribute("vo",bvo);
		
		return "blog/myBlogPage/writeForm";
	}
	
	
	/* 블로그 정보 수정 */
	@RequestMapping(value="/blog/update", method=RequestMethod.POST)
	public String blogUpdate(@ModelAttribute BlogVo vo, @RequestParam("file") MultipartFile file, Model model, HttpSession session) {
		String logo = vo.getLogo();	// 이름만 저장시 파일을 다시 받기 위해 사용
		System.out.println("logo:" + logo);
		if(!file.isEmpty()) {
			System.out.println("file:" + file);
			// 파일 이름 변경 저장 수행
			String saveFilename = fileUploadService.save(file);
			
			UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
			
			int idx = (int)(long)uvo.getNo();
			vo.setUSERS_NO(idx);	  //users_no을 활용하여 자신의 블로그 테이블에 업데이트 수행
			vo.setLogo(saveFilename); //변경된 사진 이름 저장
			boolean result = blogService.update(vo);
			
			String urlImage = "images/" + saveFilename;
			model.addAttribute("vo",vo);
			model.addAttribute("urlImage", urlImage);
			model.addAttribute("result", result);	// 업데이트가 성공되면 사진이 출력된다
			
			return "blog/myBlogPage/basic";
		}else {
			System.out.println("file없음요");
			UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
			
			int idx = (int)(long)uvo.getNo();
			vo.setUSERS_NO(idx);	  //users_no을 활용하여 자신의 블로그 테이블에 업데이트 수행
			vo.setLogo(logo);
			boolean result = blogService.update(vo);
			model.addAttribute("vo",vo);
			//model.addAttribute("result", result);	// 업데이트가 성공되면 사진이 출력된다
			
			return "blog/myBlogPage/basic";
		}
	}
}
