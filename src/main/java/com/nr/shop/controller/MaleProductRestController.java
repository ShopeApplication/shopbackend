package com.nr.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nr.shop.entity.MaleProduct;
import com.nr.shop.service.MaleProductService;

@CrossOrigin(origins = {"${ui.url}"},maxAge = 3600)
@RestController
@RequestMapping(value = "/male")
public class MaleProductRestController {
	
	@Autowired
	private MaleProductService service;
	
	@GetMapping(value = "/test")
	public String test() {
		return "HAR HAR MAHADEV";
	}
	
	@PostMapping(value = "/save")
	public MaleProduct create(@RequestBody MaleProduct maleproduct) {
		return service.create(maleproduct);
	}
	
	@GetMapping(value = "/findAll/{page}/{size}")
	@Cacheable(value = "maleProducList")
	public List<MaleProduct> findAll(@PathVariable int page,@PathVariable int size) {
		return service.findAll(page, size);
	}
	
	@GetMapping(value = "/find/{productId}")
	@Cacheable(value = "maleProducList",key = "#productId")
	public MaleProduct find(@PathVariable int productId) {
		return service.find(productId);
	}

}
