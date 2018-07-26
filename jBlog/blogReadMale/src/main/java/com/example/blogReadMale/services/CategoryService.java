/**
 * 카테고리 컨트롤러 서비스
 * 
 * */
package com.example.blogReadMale.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogReadMale.vo.CategoryVo;
import com.example.blogReadMale.vo.PostVo;
import com.exmaple.blogReadMale.repositories.CategoryDao;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	/*카테고리 List*/
	public List<CategoryVo> getList() {
		return categoryDao.selectAll();
	}
	
	/*특정 사용자 카테고리 List*/
	public List<CategoryVo> getList(int idx) { 
		return categoryDao.getUserCategory(idx);
	}
	
	/*public List<Object> getList(int idx) { 
		return categoryDao.getUserCategory(idx);
	}*/
	
	/*카테고리마다의 post_count 가져오기*/
	public CategoryVo getPost_count(int idx) {
		return categoryDao.getPost_count(idx);
	}
	
	public boolean insert(CategoryVo vo) {
		int count = categoryDao.insert(vo);
		return count==1;
	}
	
	public boolean delete(int idx) {
		int count = categoryDao.delete(idx);
		return count==1;
	}
	
	public CategoryVo getCategoryNo(String name) {
		CategoryVo vo = categoryDao.getCategoryNo(name);
		return vo;
	}

	public CategoryVo getCategoryNo(int idx) {
		CategoryVo vo = categoryDao.getCategoryNo(idx);
		return vo;
	}
	
	public boolean update(Map<String, Object> map) {
		int count = categoryDao.update(map);
		return count==1;
	}
	
	public int getTotalCategory(int idx) {
		return categoryDao.getTotalCategory(idx);
	}
}
