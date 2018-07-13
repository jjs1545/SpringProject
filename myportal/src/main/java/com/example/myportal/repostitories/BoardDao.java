package com.example.myportal.repostitories;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.myportal.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> selectAll() {
		return sqlSession.selectList("board.selectAll");	/*select해서 List로 받기*/
	}
	
	public int insert(BoardVo vo) {
		return sqlSession.insert("board.insert", vo);
	}
}
