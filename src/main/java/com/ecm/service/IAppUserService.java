package com.ecm.service;

import org.springframework.stereotype.Service;

import com.ecm.entity.AppUser;

@Service
public interface IAppUserService {

	public String registerUser(AppUser ap); 
}
