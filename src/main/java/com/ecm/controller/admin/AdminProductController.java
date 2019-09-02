package com.ecm.controller.admin;

import static com.ecm.common.ViewConstants.PRODUCT_FOLDER;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecm.common.GenderEnum;
import com.ecm.common.ImageUtility;
import com.ecm.common.ProductTagsEnum;
import com.ecm.common.StatusEnum;
import com.ecm.entity.ProductCategory;
import com.ecm.entity.ProductEntity;
import com.ecm.service.ProductCategoryService;
import com.ecm.service.ProductEntityService;

@Controller
@RequestMapping(path ="/admin")
public class AdminProductController {
	public AdminProductController() {
	System.out.println("ProductController.ProductController()admin");
	}
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductEntityService productEntityService;
	
	@GetMapping(path ="/add/category")
	public String addProductCategory(Model model){
		System.out.println("ProductController.addProductCategory()");
		model.addAttribute("productCategory", new ProductCategory());
		model.addAttribute("genderList", GenderEnum.values());
		return "product-category";
	}
	
	@RequestMapping(value = "/save/category", method = RequestMethod.POST)
	public String saveProductCategory(@ModelAttribute("productCategory") ProductCategory productCategory,RedirectAttributes redirectAttributes){
		System.out.println("ProductController.addProductCategory()");
		System.out.println(productCategory.toString());
		productCategoryService.save(productCategory);
		redirectAttributes.addFlashAttribute("message", "Category added successfully!");
		return "redirect:/admin/add/category";
	}
	
	@GetMapping(path ="/add/product")
	public String addProduct(Model model){
		System.out.println("AdminProductController.addProduct()");

		List<ProductCategory> productCategoryList = productCategoryService.findAll();
		List<ProductEntity> productList = productEntityService.findAll();
		model.addAttribute("productList", productList);
		model.addAttribute("productCategoryList", productCategoryList);
		model.addAttribute("productEntity", new ProductEntity());
		model.addAttribute("statusList", StatusEnum.values());
		model.addAttribute("tagList", ProductTagsEnum.values());
		return "add-product";
	}
	
	@RequestMapping(value = "/save/product", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("productEntity") ProductEntity productEntity,BindingResult result,RedirectAttributes redirectAttributes) throws IOException{
		System.out.println(productEntity.toString());
		ImageUtility imu = new ImageUtility();
		List<ProductEntity> productList = productEntityService.findAll();
		ProductEntity lastRecord = productList.get(productList.size() - 1);
		System.out.println(lastRecord);
		productEntity.setProductUrl(imu.getAbsoluteImagePath(productEntity.getDocumentFile(), lastRecord.getId() + 1, PRODUCT_FOLDER));
		productEntityService.save(productEntity);
		
		redirectAttributes.addFlashAttribute("message", "Product added successfully!");
		return "redirect:/admin/add/product";
	}

}
