package com.ecm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecm.dao.AppUserRepo;
import com.ecm.entity.AppUser;
import com.ecm.service.IAppUserService;

@Service
public class AppUserImpl implements IAppUserService{

	@Autowired
	private AppUserRepo appUser;
	
	@Override
	public String registerUser(AppUser ap) {
		ap.setEmail("shank@gmail.com");
		ap.setName("name");
		ap.setPassword("123");
		 ap = appUser.save(ap);
		 if(ap==null)
			 return "Registration failed";
		return "Registration successed";
	}

}
