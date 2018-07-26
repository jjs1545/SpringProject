/**
 * 카테고리 DAO
 * 
 * */
package com.exmaple.blogReadMale.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.blogReadMale.vo.CategoryVo;
import com.example.blogReadMale.vo.PostVo;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSession sqlSession;
	
	/*카테고리 List*/
	public List<CategoryVo> selectAll() { 
		List<CategoryVo> list = sqlSession.selectList("category.selectAll");
		return list;
	}
	
	/*특정 사용자 카테고리 List*/
	public List<CategoryVo> getUserCategory(int idx) { 
		List<CategoryVo> list = sqlSession.selectList("category.getUserCategory",idx);
		return list;
	}

	/*카테고리마다의 post_count 가져오기*/
	public CategoryVo getPost_count(int idx) {
		CategoryVo vo = sqlSession.selectOne("category.getpost_count", idx);
		return vo;
	}
	
	public int insert(CategoryVo vo) {
		return sqlSession.insert("category.insert", vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("category.delete", idx);
	}
	
	
	public CategoryVo getCategoryNo(String name) {
		CategoryVo categoryvo = sqlSession.selectOne("category.getcategoryno",name);
		return categoryvo;
	}
	
	public CategoryVo getCategoryNo(int idx) {
		CategoryVo categoryvo = sqlSession.selectOne("category.getcategorynoIdx",idx);
		return categoryvo;
	}
	
	public int update(Map<String, Object> map) {
		int count = sqlSession.update("category.update",map);
		return count;
	}
	
	public int getTotalCategory(int idx) {
		int totalCategory = sqlSession.selectOne("category.getTotalCategory",idx);
		return totalCategory;
	}
}
