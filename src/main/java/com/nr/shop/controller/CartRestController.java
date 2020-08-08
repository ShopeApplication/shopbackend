package com.nr.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nr.shop.service.CartService;

@CrossOrigin(origins = {"${ui.url}"},maxAge = 3600)
@RestController
@RequestMapping("/cart")
public class CartRestController {
	
	@Autowired
	private CartService service;
	
	@PostMapping("addToCart")
	public int addToCart(@PathVariable int userId,@PathVariable int productId) {
		return service.addToCart(userId, productId);
	}
	

}
