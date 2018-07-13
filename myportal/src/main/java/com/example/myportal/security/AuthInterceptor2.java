package com.example.myportal.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.myportal.vo.UserVo;

public class AuthInterceptor2 extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 1. handler의 종류 확인 -> 외부에서 잘못된 url이 침투할 수 있으므로 종류 확인을 한다
		if (handler instanceof HandlerMethod == false) {
			return true;
		}
		
		// 2. handler를 HandlerMethod로 Casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		// 3. Method에 붙어 있는 @Auth를 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		// 4. Method에 붙어 있지 않으면 Class(Type)에 @Auth를 받아오기
		if(auth==null) {
			auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
		}
		
		// 5. Method와 Type에 @Auth가 없을 때의 처리
		if(auth == null) {
			return true;
		}
		
		// 6. @Auth가 붙어 있다 인증 여부 확인
		HttpSession session = request.getSession();
		//UserVo authUser = (UserVo)session.getAttribute("authUser");
		UserVo authUser = null;
		
		if (session != null) {
			authUser = (UserVo)session.getAttribute("authUser");
		} 
		
		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		// 로그인 필요하고 로그인 된 상태
		//	return super.preHandle(request, response, handler);
		return true;
	}
}
