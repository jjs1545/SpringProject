package com.exmaple.blogReadMale.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.blogReadMale.vo.CommentVo;
import com.example.blogReadMale.vo.PagingVo;
import com.example.blogReadMale.vo.PostVo;

@Repository
public class PostDao {
	@Autowired
	private SqlSession sqlSession;
	
	//페이징 처리를 위한 map
	Map<String, Object> map = new HashMap<>();
	
	public int insert(PostVo vo) {
		int count = sqlSession.insert("post.postInsert",vo);
		return count;
	}
	
	public PostVo selectPost(int idx) {
		PostVo postvo = sqlSession.selectOne("post.selectPost",idx);
		return postvo;
	}
	
	/*category 별 해당 최신 포스트 가져오기*/
	public PostVo getPost(int idx) {
		PostVo postvo = sqlSession.selectOne("post.getPost",idx);
		return postvo;
	}
	
	/*블로거의 카테고리별 포스트 리스트 Dao*/
	public List<PostVo> getPostList(int idx) {
		List<PostVo> list = sqlSession.selectList("post.getPostList",idx);
		return list;
	}
	
	/*블로거의 카테고리별 포스트 리스트 Dao 페이징 처리*/
	
	public PagingVo getcPostPageCount(int idx,int logsPerPage) {
		map.put("idx", idx);	//블로그 넘버
		map.put("logsPerPage", logsPerPage);
		System.out.println("logsPerPage:" + logsPerPage);
		return sqlSession.selectOne("post.getcPostPageCount", logsPerPage);
	}
	
	public List<PostVo> getContentListByPage(int idx, int currPage, int logsPerPage){
		int startPos = (currPage - 1) * logsPerPage;
		map.put("idx", idx);	//블로그 넘버
		map.put("startPos", startPos);
		map.put("logsPerPage", logsPerPage);
		
		return sqlSession.selectList("post.getContentListByPage", map);
	}
	
	/****************************************/
	
	/*카테고리별 가장 최신의 포스트를 가져오기 위한 service*/
	public PostVo getlastPost(int idx) {
		PostVo maxPost = sqlSession.selectOne("post.getlastPost", idx);
		return maxPost;
	}
	
	/*사용자별 포스트 리스트*/ 
	public List<PostVo> getUserPost(int idx) {
		List<PostVo> list = sqlSession.selectList("post.getUserPost",idx);
		return list;
	}
	
	/* 사용자별 포스트 리스트 페이징 처리 */
	public PagingVo getMaxPageCount(int idx,int logsPerPage) {
		map.put("idx", idx);	//블로그 넘버
		map.put("logsPerPage", logsPerPage);
		System.out.println("logsPerPage:" + logsPerPage);
		return sqlSession.selectOne("post.getMaxPageCount", map);
	}
	
	public List<PostVo> getcPostListPage(int idx, int currPage, int logsPerPage){
		int startPos = (currPage - 1) * logsPerPage;
		map.put("idx", idx);	//블로그 넘버
		map.put("startPos", startPos);
		map.put("logsPerPage", logsPerPage);
		
		return sqlSession.selectList("post.getcPostListPage", map);
	}
}
