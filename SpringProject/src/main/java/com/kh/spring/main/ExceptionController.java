package com.kh.spring.main;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 모든오류를 캐치해주는 컨트롤러(어플리케이션 전역에서 발생하는 예외를 모아서 처리해줌)
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		e.printStackTrace();
		
		model.addAttribute("errorMsg", "서비스 이용 중 문제가 발생했습니다.");
		
		return "common/errorPage";
	}
}
