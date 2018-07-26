/**
 * 포스트 컨트롤러 서비스
 * 
 * 
 * */
package com.example.blogReadMale.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogReadMale.vo.CommentVo;
import com.example.blogReadMale.vo.PagingVo;
import com.example.blogReadMale.vo.PostVo;
import com.exmaple.blogReadMale.repositories.PostDao;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;
	
	public boolean insert(PostVo vo) {
		int count = postDao.insert(vo); 
		return count==1;
	}
	
	/*포스트 클릭시 포스트 가져오기*/
	public PostVo selectPost(int idx) {
		return postDao.selectPost(idx);
	}
	
	/*category 별 해당 최신 포스트 가져오기*/
	public PostVo getPost(int idx) {
		return postDao.getPost(idx);
	}
	
	/*블로거의 카테고리별 포스트 리스트 service*/
	public List<PostVo> getPostList(int idx) {
		return postDao.getPostList(idx);
	}
	
	/*블로거의 카테고리별 포스트 리스트 service Paging 처리*/
	public PagingVo getcPostPageCount(int idx, int logsPerPage) {
		return postDao.getcPostPageCount(idx, logsPerPage);
	
	}
	
	public List<PostVo> getcPostListPage(int idx, int currPage, int logsPerPage) {
		return postDao.getcPostListPage(idx, currPage, logsPerPage);
	}
	
	
	/*카테고리별 가장 최신의 포스트를 가져오기 위한 service*/
	public PostVo getlastPost(int idx) {
		return postDao.getlastPost(idx);
	}

	/*블로거의 카테고리별 포스트를 가져오기 위한 service*/
	public List<PostVo> getUserPost(int idx) {
		return postDao.getUserPost(idx);
	}
	
	
	/* 블로거의 카테고리별 포스트를 가져오기 위한 service 페이징 처리 */
	public PagingVo getMaxPageCount(int idx, int logsPerPage) {
		return postDao.getMaxPageCount(idx, logsPerPage);
	}
	
	public List<PostVo> getContentListByPage(int idx, int currPage, int logsPerPage) {
		return postDao.getContentListByPage(idx, currPage, logsPerPage);
	}
}
