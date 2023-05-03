package com.kh.spring.board.model.service;

import java.util.List;

import com.kh.spring.board.model.vo.Reply;

public interface ReplyService {
	
	// 댓글 등록
	public int insertReply(Reply reply);
	// 댓글 목록 조회
	List<Reply> selectReplyList(int boardNo);
	// 댓글 수정
	
	// 댓글 삭제

}
