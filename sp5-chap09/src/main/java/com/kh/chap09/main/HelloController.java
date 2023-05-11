package com.kh.chap09.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String Name(String name, Model model) {
		
		model.addAttribute("name", name);
		return "main";
	}
}
