package com.example.blogReadMale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogReadMale.vo.CategoryVo;
import com.exmaple.blogReadMale.repositories.CategoryDao;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	public List<CategoryVo> getList() {
		return categoryDao.selectAll();
	}
}
