package com.ecm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecm.common.OrderTypeEnum;
import com.ecm.common.StatusEnum;
import com.ecm.dao.ProductOrderRepository;
import com.ecm.entity.AppUser;
import com.ecm.entity.ProductOrder;
import com.ecm.service.ProductOrderService;

@Service
public class ProductOrderServiceImpl implements ProductOrderService{

	@Autowired
	private ProductOrderRepository productRepository;

	@Override
	public void save(ProductOrder prdtOrd) {
		productRepository.save(prdtOrd);		
	}

	@Override
	public ProductOrder findById(Long id) {
		return productRepository.findById(id).orElse(new ProductOrder());
	}

	@Override
	public List<ProductOrder> findByUserAndOrderTypeEnumAndStatus(AppUser user, OrderTypeEnum cart, StatusEnum active) {
		return productRepository.findByUserAndOrderTypeEnumAndStatus(user,cart,active);
	}
	
}
