package com.example.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myportal.paging.Paging;
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

	//게시물 목록 표시(페이징)
	public List<BoardVo> writeList(int offset, int noOfRecords) throws Exception {
		return boardDao.writeList(offset, noOfRecords);
	}

	//전체 게시물 수 조회
	public int writeGetCount() throws Exception {
		return boardDao.writeGetCount();
	}


}
