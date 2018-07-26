package com.example.myportal.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myportal.repostitories.LogsDao;
import com.example.myportal.service.LogService;
import com.example.myportal.vo.GuestbookVo;
import com.example.myportal.vo.LogVo;
import com.example.myportal.vo.PagingVo;

@Controller
@RequestMapping("/log")
public class LogController {
	private static final long serialVersionUID = -1860912545461126741L;
	private static final int DEFAULT_LOGS_PER_PAGE = 10;
	private static final int DEFAULT_NAV_PAGE_COUNT = 10;
	
	@Autowired
	private LogService logService;
	
	@RequestMapping({"","/list"})
	public String list(Model model, HttpServletRequest req, HttpServletResponse resp) {
		
		int currPage = 1;
		int logsPerPage = DEFAULT_LOGS_PER_PAGE;
		int maxPage = 1;
		int navStartPage = 1;
		int remains=0;
		List<LogVo> contents = null;
		
		//		현재 페이지 받아오기
		if (req.getParameter("page") != null) {
			try {
				currPage = Integer.valueOf(req.getParameter("page"));
			} catch (NumberFormatException e) {
				System.err.println("page 파라미터 포맷 오류");
			}
		}
		
		//	마지막 페이지 얻어오기
		LogsDao dao = new LogsDao();
		PagingVo pvo = logService.getMaxPageCount(logsPerPage);
				
				//(PagingVo)dao.getMaxPageCount(logsPerPage);
		
		maxPage = pvo.getMaxPage();
		remains = pvo.getRemains();
		// 정수 나눗셈의 나머지가 있다면 한페이지 추가
		if (remains > 0) {
			maxPage += 1;
		}
		
		//	현재 페이지의 게시물 얻어오기
		contents = logService.getContentListByPage(currPage, logsPerPage);
				
				//dao.getContentListByPage(currPage, logsPerPage);
		
		//	Navigation Start Page 계산
		navStartPage = (currPage - 1) / 10 * 10 + 1;
		
		//	Response 처리시 사용할 객체를 세팅
		req.setAttribute("currPage", currPage);
		req.setAttribute("logsPerPage", logsPerPage);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("contents", contents);
		req.setAttribute("navStartPage", navStartPage);
		req.setAttribute("navPageCount", DEFAULT_NAV_PAGE_COUNT);
	
		return "log/list";
	}
}
