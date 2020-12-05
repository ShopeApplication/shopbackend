package com.nr.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nr.shop.dto.ProductDTO;
import com.nr.shop.entity.MaleProduct;
import com.nr.shop.service.MaleProductService;
import com.nr.shop.service.MasterService;

import net.sf.json.JSONObject;

@CrossOrigin(origins = {"${ui.url}"},maxAge = 3600)
@RestController
@RequestMapping("/distributer")
public class DistributerRestController {
	
	//This API will be called only by user having DISTRIBUTER role
	
	@Autowired
	MasterService masterservice;
	
	@Autowired
	private MaleProductService maleproductservice;
	
	//Master
	@GetMapping("/header")
	public JSONObject header(){
		try {
			return masterservice.adminHeader("distributer");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Product
	@PostMapping(value = "/saveAnyProduct",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public MaleProduct saveAnyProduct(@RequestBody ProductDTO maleproduct,@RequestParam("file") MultipartFile file) {
		return null;
	}
	
	//Male
	@PostMapping(value = "/save")
	public MaleProduct create(@RequestBody MaleProduct maleproduct) {
		return maleproductservice.create(maleproduct);
	}
	
	@GetMapping(value = "/findAll/{page}/{size}")
	@Cacheable(value = "maleProducList")
	public List<MaleProduct> findAll(@PathVariable int page,@PathVariable int size) {
		return maleproductservice.findAll(page, size);
	}
	
	@GetMapping(value = "/find/{productId}")
	@Cacheable(value = "maleProducList",key = "#productId")
	public MaleProduct find(@PathVariable int productId) {
		return maleproductservice.find(productId);
	}

}
