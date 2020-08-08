package com.nr.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nr.shop.dao.CartDao;
import com.nr.shop.entity.Cart;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao dao;

	@Override
	public int addToCart(int userId, int productId) {
		Cart cart = dao.save(new Cart(userId,productId,0));
		if(cart == null)
		   return 0;
		return 1;
	}

}
