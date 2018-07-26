/**
 * 블로그 컨트롤러 서비스
 * 
 * */
package com.example.blogReadMale.services;

import java.util.HashMap;
import java.util.List;

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
	
	
	/* 블로그 제목 검색 결과 */
	public List<BlogVo> getSearhResult(String str) {
		return blogDao.getSearhResult(str);
	}
	
	/* 블로거 검색 결과 */
	public List<BlogVo> getSearhResult2(String str) {
		return blogDao.getSearhResult2(str);
	}
	
	/*모든 블로그 출력*/
	public List<BlogVo> getAllBlogList() {
		return blogDao.getAllBlogList();
	}
}
