package com.ecm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller					
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/home")
	public String registerPage(Model model) {
		System.out.println("AdminController.registerPage()");
		return "admin-home";
	}
}
