package com.nr.shop.controller;

import java.text.BreakIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nr.shop.service.MasterService;
import com.nr.shop.utils.JwtToken;

import io.jsonwebtoken.Claims;
import net.sf.json.JSONObject;


@CrossOrigin(origins = {"${ui.url}"},maxAge = 3600)
@RestController
@RequestMapping("/master")
public class MasterRestController {
	@Autowired
	MasterService service;
	
	@Autowired
	private UserDetailsService userDetailService;
	
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
	@GetMapping("/adminHeader/{jwt}")
	public JSONObject adminHeader(@PathVariable String jwt){
		try {
			UserDetails userdetails=userDetailService.loadUserByUsername(JwtToken.extractUsernane(jwt));
			String role=userdetails.getAuthorities().stream().findFirst().toString();
			role=role.substring(9, role.length()-1);
			return service.adminHeader(role.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
