package com.ecm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecm.dao.ProductEntityRepository;
import com.ecm.entity.ProductEntity;
import com.ecm.service.ProductEntityService;

@Service
public class ProductEntityServiceImpl implements ProductEntityService{

	@Autowired
	private ProductEntityRepository productRepository;

	@Override
	public List<ProductEntity> findAll() {
		return  productRepository.findAll();
	}

	public ProductEntityServiceImpl() {
		System.out.println("ProductServiceImpl.ProductServiceImpl()");
	}

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElse(new ProductEntity());
    }
	
}
