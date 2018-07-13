package com.example.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myportal.repostitories.BoardDao;
import com.example.myportal.vo.BoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> getList() {
		return boardDao.selectAll();
	}
	
	public boolean write(BoardVo vo) {
		int count = boardDao.insert(vo);
		return count == 1;
	}
}
