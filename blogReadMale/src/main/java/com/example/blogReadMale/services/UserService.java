package com.example.blogReadMale.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogReadMale.vo.UserVo;
import com.exmaple.blogReadMale.repositories.UserDao;

@Service
public class UserService{
	//DAO 링크
	@Autowired
	private UserDao userDao;
	
	public boolean join(UserVo vo) {
		return userDao.insert(vo) == 1;
	}
	
	public UserVo getUserByIdAndPassword(String id, String password) {
		return userDao.getUserByIdAndPassword(id,password);
	}
	
	public boolean getUserById(String id) {
		boolean exists;
		UserVo vo = userDao.getUserById(id);
		
		if(vo == null) {
			exists = false;
		} else {
			exists = true;
		}
		
		return exists;
	}
	
	public UserVo getUserInfo(String id) {
		UserVo vo = userDao.getUserInfo(id);
		return vo;
	}
}