package com.example.myportal.repostitories;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.myportal.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	// 가입(insert)
	public int insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		return count;
	}
	
	// 사용자 검색 (email, password)
	public UserVo getUserByEmailAndPassword(String email, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("email", email);
		userMap.put("password", password);
		
		UserVo userVo = sqlSession.selectOne("user.selectUserByEmailAndPassword",userMap);
		return userVo;
	}
	
	// 사용자 검색 by email -> 중복 검사
	public UserVo getUserByEmail(String email) {
		UserVo userVo = sqlSession.selectOne("user.selectUserByEmail", email);
		return userVo;
	}
}
