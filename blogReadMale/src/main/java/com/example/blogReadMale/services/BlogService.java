package com.example.blogReadMale.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogReadMale.vo.BlogVo;
import com.example.blogReadMale.vo.UserVo;
import com.exmaple.blogReadMale.repositories.BlogDao;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;
	
	public boolean insert(BlogVo vo) {
		int count = blogDao.insert(vo);
		return count==1;
	}
	
	public HashMap<String,String> selectById(String id) {
		return blogDao.selectById(id);
	}
	
	public BlogVo getBlogInfo(int idx) {
		BlogVo vo = blogDao.getBlogInfo(idx);
		return vo;
	}
	
	public boolean update(BlogVo vo) {
		int count = blogDao.update(vo);
		return count==1;
	}
}
