package com.nr.shop.service;

import java.util.List;

import com.nr.shop.entity.MaleProduct;

public interface MaleProductService {
	
	public MaleProduct create(MaleProduct maleproduct);
	
	public List<MaleProduct> findAll(int page,int size);
	
	public MaleProduct find(int id);

}
