package com.mystudy.myapp.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;
import com.mystudy.myapp.member.model.service.MemberService;
import com.mystudy.myapp.member.model.vo.Member;

@Controller
@RequestMapping("/member")
@SessionAttributes({"loginUser"})
public class MemberController {

	private MemberService memberService;
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public MemberController(MemberService memberService, BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.memberService = memberService;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
	}
	
	@PostMapping("/login")
	public String loginMember(Member m,
							Model model,
							HttpSession session) {
		Member loginUser = memberService.loginMember(m);
		
		if(loginUser != null && bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())) {
			model.addAttribute("loginUser", loginUser);
			
			session.setAttribute("alertMsg", "로그인 성공");
			return "redirect:/";
		}else {
			session.setAttribute("alertMsg", "아이디 및 비밀번호가 일치하지 않습니다.");
			
			return "redirect:/";
		}
	}
	
	@GetMapping("/insert")
	public String insertMemberPage() {
		return "/member/memberEnrollForm";
	}
	
	@PostMapping("/insert")
	public String insertMember(Member m,
								HttpSession session) {
		
		
		// 암호화
		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
		m.setUserPwd(encPwd);
		
		int result = memberService.insertMember(m);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "회원가입 성공");
		}else {
			session.setAttribute("alertMsg", "회원가입 실패");
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/logout")
	public String logoutMember(HttpSession session, SessionStatus status) {
		
		status.setComplete();
		
		return "redirece:/";
	}

	@ResponseBody
	@GetMapping("/idCheck")
	public String idCheck(String userId) {
		
		int result = memberService.idCheck(userId);
		
		return new Gson().toJson(result);
	}
}
