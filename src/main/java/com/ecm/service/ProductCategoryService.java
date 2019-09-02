package com.ecm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecm.entity.ProductCategory;

@Service
public interface ProductCategoryService {

	void save(ProductCategory productCategory);

	List<ProductCategory> findAll();

}
