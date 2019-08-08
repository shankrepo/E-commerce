package com.ecm.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecm.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Serializable>, JpaSpecificationExecutor<ProductEntity> {


}
