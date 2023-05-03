package com.kh.spring.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.ReplyDao;
import com.kh.spring.board.model.vo.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDao replyDao;
	
	// 댓글 등록
	public int insertReply(Reply reply) {
		return replyDao.insertReply(reply);
	}
	
	// 댓글 목록 조회
	public List<Reply> selectReplyList(int boardNo){
		return replyDao.selectReplyList(boardNo);
	}
	// 댓글 수정
	
	// 댓글 삭제
}
