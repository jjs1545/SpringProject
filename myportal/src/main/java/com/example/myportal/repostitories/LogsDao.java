package com.example.myportal.repostitories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.myportal.vo.LogVo;
import com.example.myportal.vo.PagingVo;

@Repository
public class LogsDao {
	@Autowired
	private SqlSession sqlSession;
	
	
	public PagingVo getMaxPageCount(int logsPerPage) {
		System.out.println("logsPerPage:" + logsPerPage);
		return sqlSession.selectOne("log.getMaxPageCount", logsPerPage);
	}
	
	public List<LogVo> getContentListByPage(int currPage, int logsPerPage){
		Map<String, Object> map = new HashMap<>();
		int startPos = (currPage - 1) * logsPerPage;
		map.put("startPos", startPos);
		map.put("logsPerPage", logsPerPage);
		
		return sqlSession.selectList("log.getContentListByPage", map);
	}
}
