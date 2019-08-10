package com.ecm.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecm.common.OrderTypeEnum;
import com.ecm.common.SizeEnum;
import com.ecm.entity.AppUser;
import com.ecm.entity.ProductEntity;
import com.ecm.entity.ProductImage;
import com.ecm.entity.ProductOrder;
import com.ecm.entity.ProductPrice;
import com.ecm.entity.ProductReview;
import com.ecm.service.IAppUserService;
import com.ecm.service.ProductEntityService;
import com.ecm.service.ProductImageService;
import com.ecm.service.ProductOrderService;
import com.ecm.service.ProductPriceService;
import com.ecm.service.ProductReviewService;

@Controller					
@RequestMapping(path ="/product")
public class ProductController {
	
	
public ProductController() {
	// TODO Auto-generated constructor stub
	System.out.println("ProductController.ProductController()");
}

	@Autowired
	private ProductEntityService productService;
	
	@Autowired
	private ProductImageService productImageService;
	
	@Autowired
	private ProductPriceService productPriceService;
	
	@Autowired
	private ProductOrderService productOrderService;
	
	@Autowired
	private ProductReviewService productReviewService;
	
	@Autowired
	private IAppUserService appUserService;
	
	@GetMapping(path ="/{id}")
	public String getProductDetails(@PathVariable Long id,Model model){
		ProductEntity obj = productService.findById(id);
		List<ProductImage> imgsList = productImageService.findByProductEntity(obj);
		List<ProductPrice> allPriceList = productPriceService.findByProductEntity(obj);
		List<ProductPrice> priceList = allPriceList.stream().filter(qut -> qut.getQuantity() != 0).collect(Collectors.toList());
		Long uid = (long) 1;
		AppUser user = appUserService.findById(uid);
		List<ProductReview> reviewList = productReviewService.FindByProductEntity(obj);
		
		if(priceList.isEmpty()) {
			model.addAttribute("avilability", "Out Of Stock");
		}else {
			model.addAttribute("avilability", "In Stock");	
		}
		System.out.println("hello wordl"+priceList);
		model.addAttribute("productObj", obj);
		model.addAttribute("priceList", priceList);
		model.addAttribute("productImgs", imgsList);
		return "productDetail";
}
	@PostMapping(path ="/save/order")
	public String saveProductOrder(HttpServletRequest request,RedirectAttributes redirectAttributes){
		String productId = request.getParameter("productId");
		String size = request.getParameter("size");
		String quantity = request.getParameter("quantity");
		String actionType = request.getParameter("actionType");
		System.out.println("actionType"+actionType+"quantity"+quantity+"size"+size+"productId"+productId);
		if(!StringUtils.isEmpty(productId) && !StringUtils.isEmpty(size) && !StringUtils.isEmpty(quantity) && actionType.contains("Cart")) {
			ProductEntity obj = productService.findById(Long.parseLong(productId));
			ProductPrice prdtprice = productPriceService.findByProductEntityAndSize(obj,SizeEnum.valueOf(size));
			ProductOrder prdtOrd = new ProductOrder();
			prdtOrd.setOrderTypeEnum(OrderTypeEnum.Cart);
			prdtOrd.setProductEntity(obj);
			prdtOrd.setProductPrice(prdtprice);
			prdtOrd.setQuantity(Integer.parseInt(quantity));
			productOrderService.save(prdtOrd);
			redirectAttributes.addFlashAttribute("successMsg","Successfully added to cart.");
		}else {
			redirectAttributes.addFlashAttribute("successMsg","Please try again.");
		}
		
		return "redirect:/product/"+productId;
	}
	
}
