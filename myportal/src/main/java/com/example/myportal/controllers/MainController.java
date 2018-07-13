package com.example.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.myportal.exceptions.MainControllerException;

@Controller
public class MainController {
	@RequestMapping({"/","main"}) /*여러개의 url을 하나의 매핑에*/
	public String main() {
		return "main/index";
	}
	
	@RequestMapping("/except")
	@ResponseBody
	public String except() {
		try{
			int result = 4/0;
		} catch (Exception e) {
			/*throw new RuntimeException(e.getMessage());*/
			throw new MainControllerException("Main Controller Error");
		}
		return "Exception Test";
	}
	
	//Exception Handler: VI
	/*@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String handlerControllerExcpet(RuntimeException e) {
		return "Exception:" + e.getMessage();
	}*/
	
	//ExceptionHandler V2
	/*@ExceptionHandler(MainControllerException.class)
	public String handlerControllerExcept(MainControllerException e, Model model) {
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message",e.getMessage());
		
		return "errors/exception";
	}*/
	
	
}
