package com.ecm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecm.common.OrderTypeEnum;
import com.ecm.common.StatusEnum;
import com.ecm.entity.AppUser;
import com.ecm.entity.ProductOrder;
import com.ecm.service.IAppUserService;
import com.ecm.service.ProductOrderService;

@Controller					
@RequestMapping(path ="/checkout")
public class CheckOutController {

	@Autowired
	private IAppUserService appUserService;
	
	@Autowired
	private ProductOrderService productOrderService;
	
	@GetMapping(path = "/view")
	public String getCheckOut(Model model) {
		Long uid = (long) 1;
		AppUser user = appUserService.findById(uid);
		List<ProductOrder> productOrder = productOrderService.findByUserAndOrderTypeEnumAndStatus(user,OrderTypeEnum.Cart,StatusEnum.Active);
		model.addAttribute("productOrder", productOrder);
		return "checkout";
	}
}
