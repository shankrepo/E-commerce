package com.ecm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecm.entity.ProductEntity;
import com.ecm.entity.ProductImage;
import com.ecm.service.ProductImageService;
import com.ecm.service.ProductService;

@Controller					
@RequestMapping(path ="/product")
public class ProductController {
	
	
public ProductController() {
	// TODO Auto-generated constructor stub
	System.out.println("ProductController.ProductController()");
}

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductImageService productImageService;
	
	@GetMapping(path ="/{id}")
	public String getProductDetails(@PathVariable Long id,Model model){
		ProductEntity obj = productService.findById(id);
		List<ProductImage> imgsList = productImageService.findByProductEntity(obj);
		System.out.println("ProductController.getProductDetails()"+obj);
		model.addAttribute("productObj", obj);
		model.addAttribute("productImgs", imgsList);
		return "productDetail";
}
	
}
