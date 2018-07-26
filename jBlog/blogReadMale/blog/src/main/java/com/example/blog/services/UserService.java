package com.example.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.repositories.UserDao;
import com.example.blog.vo.UserVo;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public boolean join(UserVo vo) {
		int count = userDao.join(vo);
		return count == 1;
	}

}
