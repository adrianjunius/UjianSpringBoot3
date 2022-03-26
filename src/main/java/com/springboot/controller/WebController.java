package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.model.TitleModel;

@Controller
public class WebController {
	
	TitleModel title = new TitleModel(" BEKEN","Trans");
	
	@GetMapping("/")
	private String index(Model model) {
		model.addAttribute("titleModel", title);
		return "index";
	}
	@GetMapping("/about")
	private String about(Model model) {
		model.addAttribute("titleModel", title);
		return "about";
	}
	@GetMapping("/service")
	private String service(Model model) {
		model.addAttribute("titleModel", title);
		return "service";
	}
	@GetMapping("/project")
	private String project(Model model) {
		model.addAttribute("titleModel", title);
		return "project";
	}
	@GetMapping("/contact")
	private String contact(Model model) {
		model.addAttribute("titleModel", title);
		return "contact";
	}
	@GetMapping("/daftar")
		private String daftar(Model model) {
		model.addAttribute("titleModel", title);
		return "daftar";
	}
}
