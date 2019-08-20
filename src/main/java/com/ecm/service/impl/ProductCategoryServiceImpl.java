package com.ecm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecm.dao.ProductCategoryRepository;
import com.ecm.entity.ProductCategory;
import com.ecm.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	@Override
	public void save(ProductCategory productCategory) {
		productCategoryRepository.save(productCategory);
	}
}
