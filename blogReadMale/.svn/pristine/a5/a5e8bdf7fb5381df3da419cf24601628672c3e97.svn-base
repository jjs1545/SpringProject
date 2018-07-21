package com.example.blogReadMale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogReadMale.vo.GuestbookVo;
import com.exmaple.blogReadMale.repositories.GuestbookDao;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> list() {
		return guestbookDao.selectAll();
	}
	
	public boolean insert(GuestbookVo vo) {
		int count = guestbookDao.insert(vo);
		return count==1;
	}
}
