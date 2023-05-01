package com.kh.spring.board.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	/*
	 * 게시글 목록 조회 서비스
	 * 
	 * @PathVariable : URL경로에 포함되어있는 값을 변수로 사용할 수 있게하는 역할
	 * => ★자동으로 request scope에 등록된다 ==> jsp에서 ${value} el로 작성가능하다.
	 * 
	 * PathVariable : 요청 자원을 식별하는 경우에 사용
	 * 
	 * QueryString : 정렬, 검색 등 필터링옵션이 있을 경우 사용
	 */
	@GetMapping("/list/{boardCode}")
	public String boardList(@PathVariable("boardCode") String boardCode,
							@RequestParam(value = "cpage", defaultValue = "1") int currentPage,
							Model model,
							@RequestParam Map<String, Object> paramMap) {
		// 검색요청이 있었다면, paramMap안에는 keyword, condition이 들어가 있을 것.
		
		// 게시글 목록 조회 서비스 호출시 작업 내용
		// 1) 게시판 이름 조회
		ArrayList<Board> list = boardService.selectBoardList(currentPage, boardCode);
		
		// 2) 페이지네이션 객체 생성
		// 3) 게시글 목록 조회
	}
	
}
