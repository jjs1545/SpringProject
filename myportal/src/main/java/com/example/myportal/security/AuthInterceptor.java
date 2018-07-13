package com.example.myportal.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.myportal.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// request로 부터 세션 감지를 한다
		HttpSession session = request.getSession();
		UserVo authUser = null; 
				//(UserVo)session.getAttribute("authUser");
	
		// 세션 체크
		//session이 유효한가
		if (session != null) {
			authUser = (UserVo)session.getAttribute("authUser");
		}
		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		//return super.preHandle(request, response, handler);
		return true;
	}
	
}
