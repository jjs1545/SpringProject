package com.example.myportal.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException
		(HttpServletRequest req,
		Exception e){
			// 1. 로깅
			e.printStackTrace();
			// 2. 시스템 오류 안내 화면
			ModelAndView mav = new ModelAndView();
			mav.addObject("name", e.getClass().getSimpleName());
			mav.addObject("message", e.getMessage());
			mav.setViewName("errors/exception");
			
			return mav;
	}
}
