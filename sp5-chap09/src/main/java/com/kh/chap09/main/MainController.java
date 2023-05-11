package com.kh.chap09.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/main")
	public String mainForward() {
		
		return "main"; 
	}
}
