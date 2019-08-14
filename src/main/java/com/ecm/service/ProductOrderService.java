package com.ecm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecm.common.OrderTypeEnum;
import com.ecm.common.StatusEnum;
import com.ecm.entity.AppUser;
import com.ecm.entity.ProductOrder;

@Service
public interface ProductOrderService {

	void save(ProductOrder prdtOrd);

	ProductOrder findById(Long id);

	List<ProductOrder> findByUserAndOrderTypeEnumAndStatus(AppUser user, OrderTypeEnum cart, StatusEnum active);


}
