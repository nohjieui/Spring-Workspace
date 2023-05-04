package com.kh.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Reply;

@Repository
public class ReplyDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 댓글 등록
	public int insertReply(Reply reply) {
		return sqlSession.insert("replyMapper.insertReply",reply);
	}
	
	// 댓글 목록 조회
	public List<Reply> selectReplyList(int boardNo){
		return sqlSession.selectList("replyMapper.selectReplyList",boardNo);
	}
	// 댓글 수정
	
	// 댓글 삭제
}