package com.ecm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecm.entity.AppUser;
import com.ecm.service.IAppUserService;

@Controller					
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IAppUserService appService;
	
	@GetMapping("/registerpage")
	public String registerPage() {
		return "account";
	}
	
	@PostMapping("/register")
	public String saveUser(Model model,AppUser au) {
		model.addAttribute("userInfo", au);
		//calling IAppUserService method
		appService.registerUser(au);
		return "index";
	}
	
	@GetMapping("/myaccount")
	public String onAccount(Model model) {
		return "account";
	}
}
