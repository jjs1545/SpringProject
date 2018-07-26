/**
 * 블로그 컨트롤러
 * 
 * */
package com.example.blogReadMale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.blogReadMale.security.Auth;
import com.example.blogReadMale.services.BlogService;
import com.example.blogReadMale.services.CategoryService;
import com.example.blogReadMale.services.CommentService;
import com.example.blogReadMale.services.FileUploadService;
import com.example.blogReadMale.services.PostService;
import com.example.blogReadMale.services.UserService;
import com.example.blogReadMale.vo.BlogVo;
import com.example.blogReadMale.vo.CategoryVo;
import com.example.blogReadMale.vo.CommentVo;
import com.example.blogReadMale.vo.PagingVo;
import com.example.blogReadMale.vo.PostVo;
import com.example.blogReadMale.vo.UserVo;

@Controller
public class BlogController {
	private static final long serialVersionUID = -1860912545461126741L;
	private static final int DEFAULT_LOGS_PER_PAGE = 3;
	private static final int DEFAULT_NAV_PAGE_COUNT = 5;
	
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	
	
	
	/** 
	 * 블로그 메인
	 * 
	 * */
	
	@RequestMapping("/blog")
	public String blog() {
		return "blog/blogMain";
	}

	/** 
	 * @PathVariable 활용 블로그 생성
	 * 
	 * */
	@RequestMapping("/{id}")
	public String blog(@PathVariable String id, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse resp) {
		/*@RequestParam("cNo") int cNo*/
		String returnUrl="";
		boolean exists = false;
		String str = "";					
		String str2 = ""; String str3 =""; /*카테고리별 포스트 불러오기 위한 str 변수*/
		
		/*페이징 필드*/
		int currPage = 1;
		int logsPerPage = DEFAULT_LOGS_PER_PAGE;
		int maxPage = 1;
		int navStartPage = 1;
		int remains=0;
		List<PostVo> contents = null;
		
		/*
			UserVo authVo = (UserVo)session.getAttribute("authUser");
			int UserNo = (int)(long)authVo.getNo();			//로그인한 유저의 회원번호 가져오기
		 */		
		try {
			
			//유저가 가입되어 있는지 없는지 여부 판단.
			exists = userService.getUserById(id);
			
			//해당 유저의 id를 활용해 blog정보를 List로 가져온다
			UserVo uvo = userService.getUserInfo(id);
			model.addAttribute("uvo",uvo);			  //블로그 id 전송
			
			int idx = (int)(long)uvo.getNo();         // 사용자 no
			
			BlogVo bvo = blogService.getBlogInfo(idx);
			model.addAttribute("vo",bvo);
			
			//특정 유저의 카테고리 리스트
			List<CategoryVo> categoryList = categoryService.getList(idx); //id 통해 memeber의 no를 가져와 해당 유저의 카테고리를 출력한다.
			model.addAttribute("categoryList",categoryList);
			
			/*카테고리 넘버를 활용하여 각 카테고리마다의 포스트를 가져온다.*/
			str=request.getParameter("cNo");

			/*카테고리별 포스트 글*/
			str2=request.getParameter("pNo");
			str3=request.getParameter("categoryNo");
			
			/*카테고리를 클릭 했을 시 포스트 목록과 최신 해당 카테고리의 포스트 값*/ 
			if(str!=null) {
				int cNo = Integer.parseInt(str);
				
				
				/*카테고리별 포스트 리스트*/
				/*List<PostVo> userPostList = postService.getPostList(cNo);
				model.addAttribute("userPostList",userPostList);*/
				
				/**
				 * 카테고리별 포스트 리스트 페이징 처리
				 * */
				//현재 페이지 받아오기
				if (request.getParameter("page") != null) {
					try {
						currPage = Integer.valueOf(request.getParameter("page"));
					} catch (NumberFormatException e) {
						System.err.println("page 파라미터 포맷 오류");
					}
				}
				
				//	마지막 페이지 얻어오기
				PagingVo pvo = postService.getcPostPageCount(cNo, logsPerPage);
						
				maxPage = pvo.getMaxPage();
				remains = pvo.getRemains();
				
				// 정수 나눗셈의 나머지가 있다면 한페이지 추가
				if (remains > 0) {
					maxPage += 1;
				}
				
				
				//	현재 페이지의 게시물 얻어오기
				contents = postService.getcPostListPage(cNo, currPage, logsPerPage);
				
				//	Navigation Start Page 계산
				navStartPage = (currPage - 1) / 10 * 10 + 1;
				
				model.addAttribute("currPage", currPage);
				model.addAttribute("logsPerPage", logsPerPage);
				model.addAttribute("maxPage", maxPage);
				model.addAttribute("userPostList", contents);
				model.addAttribute("navStartPage", navStartPage);
				model.addAttribute("navPageCount", DEFAULT_NAV_PAGE_COUNT);
				
				/*카테고리별 최신 포스트*/
				PostVo getPost = postService.getPost(cNo);				
				model.addAttribute("post",getPost);
				
				int post_no=0;
				
				try {
				// 해당 포스트 의 comment 리스트 
					post_no = (int)(long)getPost.getNo();
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					List<CommentVo> clist = commentService.list(post_no);
					model.addAttribute("commentList",clist);
				}
			}else {
				
				/**
				 * default 페이지일 때의 데이터 (로그인 하지 않았을 때의 데이터)
				 * */
				
				/*가장 최근 포스트를 가져온다*/
				PostVo getPost = postService.getlastPost(idx);
				model.addAttribute("post",getPost);
				
				//사용자가 등록한 모든 포스트를 가져온다.
				/*List<PostVo> userPostList = postService.getUserPost(idx);		
				model.addAttribute("userPostList",userPostList);*/
				
				//사용자가 등록한 모든 포스트를 가져온다. (페이징 버전)

				//현재 페이지 받아오기
				if (request.getParameter("page") != null) {
					try {
						currPage = Integer.valueOf(request.getParameter("page"));
					} catch (NumberFormatException e) {
						System.err.println("page 파라미터 포맷 오류");
					}
				}
				
				//	마지막 페이지 얻어오기
				PagingVo pvo = postService.getMaxPageCount(idx, logsPerPage);
						
				maxPage = pvo.getMaxPage();
				remains = pvo.getRemains();
				
				// 정수 나눗셈의 나머지가 있다면 한페이지 추가
				if (remains > 0) {
					maxPage += 1;
				}
				
				
				//	현재 페이지의 게시물 얻어오기
				contents = postService.getContentListByPage(idx, currPage, logsPerPage);
				
				//	Navigation Start Page 계산
				navStartPage = (currPage - 1) / 10 * 10 + 1;
				
				model.addAttribute("currPage", currPage);
				model.addAttribute("logsPerPage", logsPerPage);
				model.addAttribute("maxPage", maxPage);
				model.addAttribute("userPostList", contents);
				model.addAttribute("navStartPage", navStartPage);
				model.addAttribute("navPageCount", DEFAULT_NAV_PAGE_COUNT);
				
				if(getPost != null) {
					// 해당 포스트 의 comment 리스트 
					int post_no = (int)(long)getPost.getNo();
					List<CommentVo> clist = commentService.list(post_no);
					model.addAttribute("commentList",clist);
				}
			}
		
			/*포스트 목록을 클릭 했을시 최신 포스트 글 값과 포스트 목록 가져오기*/
			if(str2!=null&str3!=null) {
				int pNo=Integer.parseInt(str2);	//포스트 no로 포스트를 가져온다
				int cNo=Integer.parseInt(str3);
				
				System.out.println("cNo:"+ cNo);
				/*카테고리별 포스트 리스트*/
				/*List<PostVo> userPostList = postService.getPostList(cNo);
				model.addAttribute("userPostList",userPostList);*/
				
				/**
				 * 카테고리별 포스트 리스트 페이징 처리
				 * 
				 * */
				//현재 페이지 받아오기
				if (request.getParameter("page") != null) {
					try {
						currPage = Integer.valueOf(request.getParameter("page"));
					} catch (NumberFormatException e) {
						System.err.println("page 파라미터 포맷 오류");
					}
				}
				
				//	마지막 페이지 얻어오기
				PagingVo pvo = postService.getcPostPageCount(cNo, logsPerPage);
						
				maxPage = pvo.getMaxPage();
				remains = pvo.getRemains();
				
				// 정수 나눗셈의 나머지가 있다면 한페이지 추가
				if (remains > 0) {
					maxPage += 1;
				}
				
				
				//	현재 페이지의 게시물 얻어오기
				contents = postService.getcPostListPage(cNo, currPage, logsPerPage);
				
				//	Navigation Start Page 계산
				navStartPage = (currPage - 1) / 10 * 10 + 1;
				
				model.addAttribute("currPage", currPage);
				model.addAttribute("logsPerPage", logsPerPage);
				model.addAttribute("maxPage", maxPage);
				model.addAttribute("userPostList", contents);
				model.addAttribute("navStartPage", navStartPage);
				model.addAttribute("navPageCount", DEFAULT_NAV_PAGE_COUNT);
				
				/*포스트 클릭 시 포스트 가져오기*/
				PostVo getPost = postService.selectPost(pNo);				
				model.addAttribute("post",getPost);
				
				// comment 리스트
				List<CommentVo> clist = commentService.list(pNo);
				model.addAttribute("commentList",clist);
			}	
			
		
		}catch (Exception e){
			e.printStackTrace();
			//TODO 에러발생시 404 처리
			return "errors/exception";
		}
		
		
		
		if(exists==true) {
			returnUrl= "blog/blogMain";
		}
			
		return returnUrl;
	}
	
	
	/**
	 * 블로그 기본설정 페이지
	 * 
	 * */
	@Auth
	@RequestMapping("/{id}/admin/basic")
	public String Myblog(@PathVariable String id, Model model, HttpSession session) {
	
		try {
			UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
			int idx = (int)(long)uvo.getNo();
			BlogVo bvo = blogService.getBlogInfo(idx);		//회원가입 순서를 활용해서 유저를 구별한다.
			model.addAttribute("id",id);
			model.addAttribute("vo",bvo);
		}catch(Exception e) {
			e.printStackTrace();
			return "errors/exception";
		}
		return "blog/myBlogPage/basic";
	}
	
	/**
	 * 카테고리 별 포스트 글작성 폼
	 * 
	 * */
	@Auth
	@RequestMapping("/{id}/admin/writeForm")
	public String MyblogWrite(@PathVariable String id, Model model, HttpSession session) {
	
		UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
		int idx = (int)(long)uvo.getNo();
		
		//특정 유저의 카테고리 리스트
		List<CategoryVo> categoryList = categoryService.getList(idx); //id 통해 memeber의 no를 가져와 해당 유저의 카테고리를 출력한다.
		model.addAttribute("categoryList",categoryList);
		
		try {
			List<CategoryVo> list = categoryService.getList(idx);
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			model.addAllAttributes(map);
		}catch(Exception e){
			e.printStackTrace();
			return "errors/exception";
		}
		return "blog/myBlogPage/writeForm";
	}
	
	/**
	 * 카테고리 별 포스트 글작성 Action
	 * 
	 * */
	@Auth
	@RequestMapping("/post/write")
	public String WriteAction(@ModelAttribute PostVo vo,@ModelAttribute CategoryVo cvo, @RequestParam("select") int category_no 
			/*@RequestParam("category_no") int category_no*/, Model model, HttpSession session) {
		int idx=0;		// 포스트 수 증가를 위한 필드
		System.out.println("idx1:"+idx);
		
		UserVo uvo = (UserVo)session.getAttribute("authUser");		//세션값 가져오기
	    String id = (String)uvo.getId();
		
	   /* System.out.println("post insert");
	    System.out.println("id:" + id);*/
	    /*select Box 선택시 카테고리 이름 -> category*/
	    
	    System.out.println("cno: " + category_no);
	    /*CategoryVo cvo = categoryService.getCategoryNo(category); */
	   
	    int categoryNo = (int)(long)category_no;		//외래키 지정을 위한 카테고리 넘버를 얻는다
	    vo.setCategory_no(categoryNo);
	  
	    try {
	    	boolean result = postService.insert(vo);
	    }catch (Exception e){
	    	e.printStackTrace();
	    }finally {
	    	CategoryVo getPostCount = categoryService.getPost_count(category_no);
	    	System.out.println("getPost_count:"+ getPostCount.getPost_count());
	    	
	    	/**
	    	 * insert시 postCount 증가
	    	 * postCount를 가져와서 업데이트 한다.
	    	 * 
	    	 * */
	    	idx = getPostCount.getPost_count(); 					
	    	
	    	Map<String, Object> map = new HashMap<>();	//idx와 categoryNO을 parameter로
	    	map.put("post_count", idx);
	    	map.put("no", categoryNo);
	    	categoryService.update(map);
	    	//cvo.setPost_count(idx);     //Post삽입 시 카테고리의 포스트 수 증가
	    	
	    	//cvo.setNo(cNo);
	    	//System.out.println("idx2:"+idx);
	    	//categoryService.update(cvo);
	    }
	    
		/*List<CategoryVo> list = categoryService.getList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		model.addAllAttributes(map);*/
		
	    
	    
		return "redirect:/"+id+"/admin/writeForm";
	}
	
	
	/** 
	 * 블로그 정보 수정  Action
	 * 
	 * */
	@Auth
	@RequestMapping(value="/blog/update", method=RequestMethod.POST)
	public String blogUpdate(@ModelAttribute BlogVo vo, @RequestParam("file") MultipartFile file, Model model, HttpSession session) {
		String logo = vo.getLogo();	// 이름만 저장시 파일을 다시 받기 위해 사용
		System.out.println("logo:" + logo);
		
		try {
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
				}
			}catch(Exception e){
				e.printStackTrace();
				return "errors/exception";
			}
		
			return "blog/myBlogPage/basic";
	}
}
