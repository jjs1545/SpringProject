package com.example.myportal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myportal.repostitories.GuestbookDao;
import com.example.myportal.vo.GuestbookVo;

@Service
public class GuestbookService {
	private static final Logger Logger = LoggerFactory.getLogger(GuestbookService.class);
	@Autowired
	GuestbookDao guestbookDao;
	
	public List<GuestbookVo> list() {
		Logger.trace("TRACE log");
		Logger.debug("========== call GuestbookDao::selectAll============");
		Logger.info("INFO log");
		Logger.warn("warn log");
		Logger.error("ERROR LOG");
		return guestbookDao.selectAll();
	}
	
	public boolean insert(GuestbookVo vo) {
		int count = guestbookDao.insert(vo);
		return count==1;
	}

	public boolean deleteMessage(GuestbookVo vo) {
		int count = guestbookDao.delete(vo);
		return count==1;
	}
}
