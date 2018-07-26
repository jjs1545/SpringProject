/**
. * 유저 DAO
 * 
 * */
package com.exmaple.blogReadMale.repositories;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.blogReadMale.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	// 가입(insert)
	public int insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		//System.out.println("insert: "+ vo.getNo());
		return count;
	}
	
	// 로그인 (select)
	public UserVo getUserByIdAndPassword(String id, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("id",id);
		userMap.put("password", password);
		
		UserVo uservo = sqlSession.selectOne("user.userByIdAndPassword", userMap); 
				
		return uservo;
	}
	
	// 사용자 검색 by Id - > 중복검사
	public UserVo getUserById(String id) {
		UserVo uservo = sqlSession.selectOne("user.selectUserById",id);
		return uservo;
	}
	
	// 특정 사용자의 정보 가져오기
	public UserVo getUserInfo2(int idx) {
		UserVo uservo = sqlSession.selectOne("user.selectUser",idx);
		return uservo;
	}
	
	// 유저 정보 변경
	public int update(UserVo vo) {
		int count = sqlSession.update("user.update",vo);
		return count;
	}
}