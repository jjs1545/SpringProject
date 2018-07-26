package com.example.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myportal.repostitories.UserDao;
import com.example.myportal.vo.UserVo;

@Service
public class UserService {
	// DAO 링크
	@Autowired
	private UserDao userDao;
	
	public boolean join(UserVo vo) {
		return userDao.insert(vo) == 1;
	}
	
	public UserVo getUserByEmailAndPassword(String email, String password) {
		return userDao.getUserByEmailAndPassword(email,password);
	}
	
	public boolean exists(String email) {
		boolean exists; 
		UserVo vo = userDao.getUserByEmail(email);
		
		if (vo == null) {
			exists = false;
		} else {
			exists = true;
		}
		
		return exists;
	}
}
