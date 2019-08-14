package com.ecm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecm.common.OrderTypeEnum;
import com.ecm.common.StatusEnum;
import com.ecm.entity.AppUser;
import com.ecm.entity.ProductOrder;
import com.ecm.service.IAppUserService;
import com.ecm.service.ProductOrderService;

@Controller					
@RequestMapping(path ="/cart")
public class CartController {
	
	@Autowired
	private IAppUserService appUserService;
	
	@Autowired
	private ProductOrderService productOrderService;
	
	@GetMapping(path ="/view")
	public String getCartProduct(Model model){
		Long uid = (long) 1;
		AppUser user = appUserService.findById(uid);
		List<ProductOrder> products = productOrderService.findByUserAndOrderTypeEnumAndStatus(user,OrderTypeEnum.Cart,StatusEnum.Active);
		float total = 0;
		for (ProductOrder productOrder : products) {
			int quntity = productOrder.getQuantity();
			float price = productOrder.getProductPrice().getDiscountPrice();
			total += quntity*price;
		}
		model.addAttribute("total", total);
		model.addAttribute("products", products);
		return "cart";
	}
	
	@GetMapping(path ="/order/remove/{id}")
	public String removeProductFromCart(@PathVariable Long id,RedirectAttributes attributes){
		ProductOrder orderObj = productOrderService.findById(id);
		orderObj.setStatus(StatusEnum.In_Active);
		productOrderService.save(orderObj);
		attributes.addFlashAttribute("message", orderObj.getProductEntity().getProductName()+" removed successfully");
		return "redirect:/cart/view";
	}
	
	@GetMapping(path ="/wishlist/view")
	public String getWishlist(Model model){
		Long uid = (long) 1;
		AppUser user = appUserService.findById(uid);
		List<ProductOrder> wishlist = productOrderService.findByUserAndOrderTypeEnumAndStatus(user,OrderTypeEnum.WishList,StatusEnum.Active);
		model.addAttribute("wishlist", wishlist);
		return "wishlist";
	}
	
	@GetMapping(path ="/wishlist/order/remove/{id}")
	public String removeProductFromWishList(@PathVariable Long id,RedirectAttributes attributes){
		ProductOrder orderObj = productOrderService.findById(id);
		orderObj.setStatus(StatusEnum.In_Active);
		productOrderService.save(orderObj);
		attributes.addFlashAttribute("message", orderObj.getProductEntity().getProductName()+" removed successfully!");
		return "redirect:/cart/wishlist/view";
	}
	
	@PostMapping(path="/update/order")
	public String updateCart(HttpServletRequest request,RedirectAttributes attributes) {
		String [] id = request.getParameterValues("productId");
		String [] quantity = request.getParameterValues("quantity");
		for (int i = 0; i < id.length; i++) 
		{
			ProductOrder orderObj = productOrderService.findById(Long.parseLong(id[i]));
			orderObj.setQuantity(Integer.parseInt(quantity[i]));
			productOrderService.save(orderObj);
		}
		attributes.addFlashAttribute("message", "Cart updated successfully!");
		return "redirect:/cart/view";
	}
		}
