package com.ecm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecm.dao.AppUserRepo;
import com.ecm.entity.AppUser;
import com.ecm.entity.ProductEntity;
import com.ecm.service.IAppUserService;

@Service
public class AppUserImpl implements IAppUserService{

	@Autowired
	private AppUserRepo appUser;
	
	@Override
	public String registerUser(AppUser ap) {
		
		ap.setEmail(ap.getEmail());
		ap.setPassword(ap.getPassword());
		 ap = appUser.save(ap);
		 //if registration got failed
		 if(ap==null)
			 return "Registration failed";
		return "Registration successed";
	}

	@Override
	public AppUser findById(Long uid) {
		return appUser.findById(uid).orElse(new AppUser());
	}

}
