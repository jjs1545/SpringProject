package com.example.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.myportal.repostitories.LogsDao;
import com.example.myportal.vo.LogVo;
import com.example.myportal.vo.PagingVo;

@Service
public class LogService {
	@Autowired
	private LogsDao logDao;
	
	public PagingVo getMaxPageCount(int logsPerPage) {
		return logDao.getMaxPageCount(logsPerPage);
	}
	
	public List<LogVo> getContentListByPage(int currPage, int logsPerPage) {
		return logDao.getContentListByPage(currPage, logsPerPage);
	}
}

//	마지막 페이지 얻어오기
//maxPage = dao.getMaxPageCount(logsPerPage);
//	현재 페이지의 게시물 얻어오기
//contents = dao.getContentListByPage(currPage, logsPerPage);