package com.nr.shop.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nr.shop.entity.Cart;

@Repository
public interface CartDao extends PagingAndSortingRepository<Cart, Integer> {


}
