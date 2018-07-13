package com.example.myportal.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import com.example.myportal.service.GuestbookService;
import com.example.myportal.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	private static final Logger logger = LoggerFactory.getLogger(GuestbookService.class);
	@Autowired
	GuestbookService guestbookService;	//GuestbookService의 bean을 받아온다
	
	/*
	 * 
	 * @Autowired의 역할
	 * public GuestbookController() {
	 * // applicationContext 얻기
	 * ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
	 * guestbookService = (GuestbookService)ctx.getBean("guestbookService");
	 * }
	 * 
	*/
	
	// list V1
	//@RequestMapping("/list")
	/*@ResponseBody*/
	/*public String list(Model model) {
		// 준비
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// applicationContext 얻기
		ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		
		// 결과 값을 담을 List 선언
		List<GuestbookVo> list = new ArrayList<>();
		
		try {
			// 로직
			DataSource ds = (DataSource)ctx.getBean("dataSource"); // 생성돼있는 Bean id로 끄집어 냄
			conn = ds.getConnection();
			
			stmt = conn.createStatement();
			String sql = " SELECT no, name, password, content, regdate FROM guestbook ORDER BY regdate DESC ";
			System.out.println("SQL : " + sql);
			// select문일 때 executeQuery를 사용
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String content = rs.getString(4);
				String regdate = rs.getString(5);
				
				GuestbookVo vo = new GuestbookVo(no, name, password, content, regdate);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.err.println("SQLError");
			}
		}
//		System.out.println(list);
		model.addAttribute("list", list);
		return list.toString();
		return "guestbook/list";
	}*/
	
	//list V2
	@RequestMapping({"","/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookService.list();
		model.addAttribute("list",list);
		return "guestbook/list";
	}
	
	//방명록 작성
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVo vo) {
		// 서비스 측에 insert를 요청하고
		boolean result = guestbookService.insert(vo);
		
		//TODO: result 값으로 오류 문제 처리
		
		return "redirect:/guestbook/list";
	}
	
	//방명록 삭제 폼
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String deleteForm(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no",no);
		return "guestbook/deleteForm";
	}
	
	//방명록 삭제
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	/*@ModelAttribute는 Request에 객체가 많을경우 vo를 활용하여 vo에 속한 데이터가 있을경우 setter로 처리가 가능하다*/
	public String deleteAction(@ModelAttribute GuestbookVo vo) {		
		boolean result = guestbookService.deleteMessage(vo);
		//TODO: result 값에 따른 오류 메시지 저장
		//처리 로직을 서비스에 위임
		return "redirect:/guestbook/list";
	}
}