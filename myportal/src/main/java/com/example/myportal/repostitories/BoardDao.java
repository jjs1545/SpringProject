package com.example.myportal.repostitories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.myportal.paging.Paging;
import com.example.myportal.vo.BoardVo;
import com.example.myportal.vo.GuestbookVo;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	int noOfRecords;	//페이징을 위한 변수
	
	public List<BoardVo> selectAll() {
		return sqlSession.selectList("board.selectAll");	/*select해서 List로 받기*/
	}
	
	public int insert(BoardVo vo) {
		return sqlSession.insert("board.insert", vo);
	}

	//게시물 목록 표시(페이징)
	public List<BoardVo> writeList(int offset, int noOfRecords) throws Exception {
	
		//List<BoardVo> writeList = new ArrayList<BoardVo>(); 
		List<BoardVo> writeList = new ArrayList<>(); 
		
		HashMap<String, Object> params = new HashMap<String, Object>(); 
		
		params.put("offset", offset); 
		params.put("noOfRecords", noOfRecords);
		
		//System.out.println("offset:" + offset);
		//System.out.println("offset:" + noOfRecords);
		
		writeList = sqlSession.selectList("board.writeList", params); 
		this.noOfRecords = sqlSession.selectOne("board.writeGetCount");
		
		return writeList;
	}
	
	//게시물 레코드 수 조회
	public int writeGetCount() throws Exception {
		return sqlSession.selectOne("board.writeGetCount");
	}
	
	
}
