package com.ecm.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecm.entity.ProductReview;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Serializable>, JpaSpecificationExecutor<ProductReview> {

}
