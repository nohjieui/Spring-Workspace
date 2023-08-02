package com.mystudy.myapp.member.model.service;

import com.mystudy.myapp.member.model.vo.Member;

public interface MemberService {

	Member loginMember(Member m);

	int idCheck(String userId);

	int insertMember(Member m);

}
