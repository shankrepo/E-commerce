package com.ecm.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecm.common.GenderEnum;
import com.ecm.entity.ProductCategory;
import com.ecm.service.ProductCategoryService;

@Controller
@RequestMapping(path ="/admin")
public class AdminProductController {
	public AdminProductController() {
	System.out.println("ProductController.ProductController()admin");
	}
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@GetMapping(path ="/add/category")
	public String addProductCategory(Model model){
		System.out.println("ProductController.addProductCategory()");
		model.addAttribute("productCategory", new ProductCategory());
		model.addAttribute("genderList", GenderEnum.values());
		return "product-category";
	}
	
	@RequestMapping(value = "/save/category", method = RequestMethod.POST)
	public String saveProductCategory(@ModelAttribute("productCategory") ProductCategory productCategory){
		System.out.println("ProductController.addProductCategory()");
		System.out.println(productCategory.toString());
		productCategoryService.save(productCategory);
		return "redirect:/product/add/category";
	}

}
