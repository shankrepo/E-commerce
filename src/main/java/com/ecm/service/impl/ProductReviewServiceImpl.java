package com.ecm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecm.dao.ProductReviewRepository;
import com.ecm.service.ProductReviewService;

@Service
public class ProductReviewServiceImpl implements ProductReviewService{

	@Autowired
	private ProductReviewRepository productImageRepository;
	
	
}
