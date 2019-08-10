package com.ecm.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecm.entity.AppUser;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Serializable>, JpaSpecificationExecutor<AppUser> {
	
	
}
