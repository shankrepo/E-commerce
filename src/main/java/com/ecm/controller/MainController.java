package com.ecm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	public MainController() {
		System.out.println("MainController.MainController()");
	}

	@GetMapping("/")
	public String onBoardPage() {
		return "index";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
}

