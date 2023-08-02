package com.mystudy.myapp.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.myapp.member.model.dao.MemberDao;
import com.mystudy.myapp.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member loginMember(Member m) {
		return memberDao.loginMember(m);
	}
	
	@Override
	public int idCheck(String userId) {
		return memberDao.idCheck(userId);
	}
	
	@Override
	public int insertMember(Member m) {
		return memberDao.insertMember(m);
	}
	
}
