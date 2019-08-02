package com.ecm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecm.entity.AppUser;

@Repository
public interface AppUserRepo extends CrudRepository<AppUser,Long> {
	
	
}
