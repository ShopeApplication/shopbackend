package com.nr.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nr.shop.dao.MaleProductDao;
import com.nr.shop.entity.MaleProduct;

@Service
public class MaleProductServiceImpl implements MaleProductService {
	
	@Autowired
	private MaleProductDao dao;
	
	@Override
	public MaleProduct create(MaleProduct maleproduct) {
		return dao.save(maleproduct);
	}
	
	@Override
	public List<MaleProduct> findAll(int page,int size) {
		Pageable pageable=PageRequest.of(page, size);
		return dao.findAll(pageable).toList();
	}

	@Override
	public MaleProduct find(int id) {
		return dao.find(id);
	}

}
