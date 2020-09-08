package com.nr.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nr.shop.entity.MaleProduct;
import com.nr.shop.entity.User;
import com.nr.shop.service.MaleProductService;
import com.nr.shop.service.MasterService;
import com.nr.shop.service.UserService;
import com.nr.shop.utils.ShopBCryptPE;

import net.sf.json.JSONObject;

@CrossOrigin(origins = {"${ui.url}"},maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminRestController {
	
	//This API will be called only by user having ADMIN role
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	MasterService masterservice;
	
	@Autowired
	private MaleProductService maleproductservice;
	
	//User
	@PostMapping(value = "/createAdmin")
	public User createAdmin(@RequestBody User user) throws Exception{
		/*
		 if(mobileValid || emailValid) {
		   if(!moblieAldeadyUsed ||!emailAlreadyUsed){
		   
		   }else{
		      throw Exception("Already Used");
		   } 
		 }else{
		    throw Exception("Invalid");
		 }
		 */
		user.setStatus(1);
		user.setRole("ADMIN");
		user.setPassword(ShopBCryptPE.encrypt(user.getPassword()));
		return userservice.create(user);
	}
	
	@PostMapping(value = "/createDistributer")
	public User createDistributer(@RequestBody User user) {
		user.setStatus(1);
		user.setRole("DISTRIBUTER");
		user.setPassword(ShopBCryptPE.encrypt(user.getPassword()));
		return userservice.create(user);
	}
	
	@GetMapping(value = "/findAllUser/{page}/{size}")
	@Cacheable(value = "userList")
	public List<User> findAllUser(@PathVariable int page,@PathVariable int size) {
		return userservice.findAll(page, size);
	}
	
	@GetMapping(value = "/getUser/{id}")
	@Cacheable(value = "userList",key = "#id")
	public User getUser(@PathVariable int id) {
		return userservice.find(id);
	}
	
	@DeleteMapping(value = "/deleteUser/{id}")
	@CacheEvict(value = "userList",key = "#id")
	public void deleteUser(@PathVariable int id) {
		userservice.delete(id);
	}
	
	@PostMapping(value = "/activateUser/{id}")
	@CacheEvict(value = "userList",key = "#id")
	public void activateUser(@PathVariable int id) {
		userservice.activateUser(id);
	}
	
	//Master
	@GetMapping("/findAllJSON")
	public JSONObject findAllJSON(){
		try {
			return masterservice.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/header")
	public JSONObject header(){
		try {
			/*
			 * UserDetails
			 * userdetails=userDetailService.loadUserByUsername(JwtToken.extractUsernane(jwt
			 * )); String role=userdetails.getAuthorities().stream().findFirst().toString();
			 * role=role.substring(9, role.length()-1);
			 */
			return masterservice.adminHeader("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Male
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
