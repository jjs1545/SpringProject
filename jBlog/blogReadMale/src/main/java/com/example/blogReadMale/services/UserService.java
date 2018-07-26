/**
 * 회원가입 & 로그인 서비스
 * 
 * */
package com.example.blogReadMale.services;


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
		UserVo vo = userDao.getUserById(id);
		return vo;
	}
	
	public UserVo getUserInfo2(int idx) {
		UserVo vo = userDao.getUserInfo2(idx);
		return vo;
	}
	
	/*유저 정보 변경*/
	public boolean update(UserVo vo) {
		int count = userDao.update(vo);
		return count==1;
	}
}