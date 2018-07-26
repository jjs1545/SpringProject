package com.exmaple.blogReadMale.repositories;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.blogReadMale.vo.CategoryVo;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> selectAll() { 
		List<CategoryVo> list = sqlSession.selectList("category.selectAll");
		return list;
	}
}
