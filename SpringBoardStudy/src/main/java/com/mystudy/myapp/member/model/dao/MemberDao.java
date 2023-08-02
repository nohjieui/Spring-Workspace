package com.mystudy.myapp.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.myapp.member.model.vo.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Member loginMember(Member m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

	public int idCheck(String userId) {
		return sqlSession.selectOne("memberMapper.idCheck", userId);
	}

	public int insertMember(Member m) {
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	
	
}
