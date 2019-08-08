package com.ecm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecm.dao.ProductRepository;
import com.ecm.entity.ProductEntity;
import com.ecm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductEntity> findAll() {
		return  productRepository.findAll();
	}

	public ProductServiceImpl() {
		System.out.println("ProductServiceImpl.ProductServiceImpl()");
	}

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElse(new ProductEntity());
    }
	
}
