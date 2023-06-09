package com.ncs.test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
@SessionAttributes("{loginUser}")
public class MemberController {

//	- 알맞은 아이디, 비밀번호 입력 시 로그인 입력창이 사라지며
//	"[회원명]님 환영합니다." 문구 출력
//	- 잘못된 아이디, 비밀번호 입력 시 "로그인 실패" 경고창 출력
	@Autowired
	private MemberService memberService;
	
	public String memberLogin() {
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String memberLogin(Member m,
							  Model model) {
		Member loginUser = memberService.memberLogin(m);
		if(loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}else {
			model.addAttribute("msg", "로그인 실패");
		}
		
		return "redirect:/";
	}
}
