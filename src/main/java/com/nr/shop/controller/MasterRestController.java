package com.nr.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nr.shop.service.MasterService;

import net.sf.json.JSONObject;


@CrossOrigin(origins = {"${ui.url}"},maxAge = 3600)
@RestController
@RequestMapping("/master")
public class MasterRestController {
	@Autowired
	MasterService service;
	
	@GetMapping("/findAll")
	public JSONObject findAll(){
		try {
			return service.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/findCatagories")
	public JSONObject findCatagories(){
		try {
			return service.findCatagories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@GetMapping("/adminHeader")
	public JSONObject adminHeader(){
		try {
			return service.adminHeader();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
