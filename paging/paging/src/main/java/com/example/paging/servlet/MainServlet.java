package com.example.paging.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.paging.dao.LogsDao;
import com.example.paging.vo.LogVo;

@WebServlet({"/", "/paging"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = -1860912545461126741L;
	private static final int DEFAULT_LOGS_PER_PAGE = 10;
	private static final int DEFAULT_NAV_PAGE_COUNT = 10;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		int currPage = 1;
		int logsPerPage = DEFAULT_LOGS_PER_PAGE;
		int maxPage = 1;
		int navStartPage = 1;
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
		maxPage = dao.getMaxPageCount(logsPerPage);
		
		//	현재 페이지의 게시물 얻어오기
		contents = dao.getContentListByPage(currPage, logsPerPage);
		
		//	Navigation Start Page 계산
		navStartPage = (currPage - 1) / 10 * 10 + 1;
		
		//	Response 처리시 사용할 객체를 세팅
		req.setAttribute("currPage", currPage);
		req.setAttribute("logsPerPage", logsPerPage);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("contents", contents);
		req.setAttribute("navStartPage", navStartPage);
		req.setAttribute("navPageCount", DEFAULT_NAV_PAGE_COUNT);
		
		//	최종 결과를 처리할 JSP로 포워드
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/paging/index.jsp");
		rd.forward(req, resp);
	}

	
}
