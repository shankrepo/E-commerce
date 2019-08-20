package com.ecm.service;

import org.springframework.stereotype.Service;

import com.ecm.entity.ProductCategory;

@Service
public interface ProductCategoryService {

	void save(ProductCategory productCategory);

}
