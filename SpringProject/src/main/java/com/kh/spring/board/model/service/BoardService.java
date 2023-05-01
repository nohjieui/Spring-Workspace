package com.kh.spring.board.model.service;

import java.util.ArrayList;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardType;

public interface BoardService {

	public ArrayList<BoardType> selectBoardTypeList();
	
	public ArrayList<Board> selectBoardList(int currentPage, String boardCode);
}
