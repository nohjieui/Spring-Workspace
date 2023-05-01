package com.kh.spring.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardType;
import com.kh.spring.common.model.vo.PageInfo;
import com.kh.spring.common.template.Pagination;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private Pagination pagination;
	
	public ArrayList<BoardType> selectBoardTypeList(){
		return boardDao.selectBoardTypeList();
	}
	
	public ArrayList<Board> selectBoardList(int currentPage, String boardCode){
		int listCount = boardDao.selectBoardListCount(boardCode);
		
		int pageLimit = 10;
		int boardLimit = 5;
		PageInfo pi = pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
		
		ArrayList<Board> list = boardDao.selectBoardList(pi, boardCode);
		
		return list;
	}
}
