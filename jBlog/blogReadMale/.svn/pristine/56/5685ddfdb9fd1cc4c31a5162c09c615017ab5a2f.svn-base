package com.example.blogReadMale.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.blogReadMale.security.Auth;
import com.example.blogReadMale.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler instanceof HandlerMethod == false) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		if(auth==null) {
			auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
		}
		if(auth == null) {
			return true;
		}
		HttpSession session = request.getSession();
		UserVo authUser = null;
		
		//카테고리, 글작성 추가시 로그인한 유저가 같은 경우도 생각해준다
		/*String id =(String)session.getAttribute("id");*/
		
		String uri =request.getRequestURI();
		System.out.println(uri);
		
		String[] array = uri.split("/");
		
		/*for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}*/
		
		
		if (session != null) {
			authUser = (UserVo)session.getAttribute("authUser");
		} 

		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}/*else if(authUser.getId() != array[2]) {
			response.sendRedirect(request.getContextPath() + "/errors/exception");
			return false;
		}*/
			

		/*if(!authUser.getId().equals(id)) {
			response.sendRedirect(request.getContextPath() + "/user/main");
			return fae;ls
		}	*/
		
		return true;
	}
	
}
