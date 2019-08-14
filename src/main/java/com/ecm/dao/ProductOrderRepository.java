package com.ecm.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecm.common.OrderTypeEnum;
import com.ecm.common.StatusEnum;
import com.ecm.entity.AppUser;
import com.ecm.entity.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Serializable>, JpaSpecificationExecutor<ProductOrder> {

	List<ProductOrder> findByUserAndOrderTypeEnumAndStatus(AppUser user, OrderTypeEnum cart, StatusEnum active);
}
