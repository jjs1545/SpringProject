package com.exmaple.blogReadMale.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.blogReadMale.vo.CommentVo;
import com.example.blogReadMale.vo.PagingVo;

@Repository
public class CommentDao {
	@Autowired
	private SqlSession sqlSession;
	
	//selectAll
	public List<CommentVo> selectAll(int idx) {
		List<CommentVo> list = sqlSession.selectList("comment.selectAll",idx);
		return list;
	}
	
	public int insert(CommentVo vo) {
		int count = sqlSession.insert("comment.insert", vo);
		return count;
		
	}
	
	public int delete(int idx) {
		int count = sqlSession.delete("comment.delete", idx);
		return count;
		
	}
	
}
