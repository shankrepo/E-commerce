package com.ecm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class ProductReview {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@ManyToOne
	    @JoinColumn(name ="product_entity")
		private ProductEntity productEntity;
		private int rating;
		private String reviewDesc;
		@ManyToOne
	    @JoinColumn(name ="user")
		private AppUser user;
		
}