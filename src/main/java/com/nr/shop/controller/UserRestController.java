package com.nr.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nr.shop.dto.RequestBoby;
import com.nr.shop.entity.User;
import com.nr.shop.service.UserService;
import com.nr.shop.utils.JwtToken;
import com.nr.shop.utils.ShopBCryptPE;
import com.nr.shop.utils.ShopRegex;

@CrossOrigin(origins = {"${ui.url}"},maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsService userdetailService;
	
	@Autowired
	private UserService service;
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody RequestBoby rb) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(rb.getUsername(), rb.getPassword()));
		}catch (Exception e) {
			return new ResponseEntity<String>("Invalid Credencial.", HttpStatus.NOT_ACCEPTABLE);
		}
		UserDetails userDetail=userdetailService.loadUserByUsername(rb.getUsername());
		String jwt=JwtToken.generateToken(userDetail);
		return new ResponseEntity<String>(jwt, HttpStatus.OK);
		
	}
	
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
		return service.create(user);
	}
	
	@PostMapping(value = "/createDistributer")
	public User createDistributer(@RequestBody User user) {
		user.setStatus(1);
		user.setRole("DISTRIBUTER");
		user.setPassword(ShopBCryptPE.encrypt(user.getPassword()));
		return service.create(user);
	}
	
	@PostMapping(value = "/createUser")
	public ResponseEntity<String> createUser(@RequestBody RequestBoby rb) throws Exception {
		User user = new User();
		if(rb.getUsername().contains("@") || rb.getUsername().contains(".")) {
			//Username is Email
			if(ShopRegex.validateEmail(rb.getUsername())) {
				//Email is valid
				if(service.findByEmail(rb.getUsername()) != null) {
					return new ResponseEntity<String>("Email already in use.", HttpStatus.BAD_REQUEST);
				}else {
					//Email is already not in use
					user.setEmail(rb.getUsername());
				}
			}else {
				//Not Valid Email
				return new ResponseEntity<String>("Invalid Email.", HttpStatus.BAD_REQUEST);
			}
		}else {
			//Username is mobile
			if(ShopRegex.validateMobile(rb.getUsername())) {
				//Mobile is valid
				if(service.findByMobile(rb.getUsername()) !=null) {
					//Mobile is already used
					return new ResponseEntity<String>("Mobile already used.", HttpStatus.BAD_REQUEST);
				}else {
					//mobile is alredy not used
					try {
						Long.parseLong(rb.getUsername());
						user.setMobile(rb.getUsername());
					}catch (Exception e) {
						// Ivalid Mobile number
						return new ResponseEntity<String>("Invalid Mobile.", HttpStatus.BAD_REQUEST);
					}
				}
			}else {
				//mobile not valid
				return new ResponseEntity<String>("Invalid Mobile.", HttpStatus.BAD_REQUEST);
			}
		}
		user.setStatus(1);
		user.setRole("USER");
		user.setPassword(ShopBCryptPE.encrypt(rb.getPassword()));
		User res=service.create(user);
		if(res != null) {
			//User created
			return new ResponseEntity<String>("Account Created", HttpStatus.OK);
		}
		//User not Created  
		return new ResponseEntity<String>("Failed to create user.", HttpStatus.OK);
	}
	
	@GetMapping(value = "/findAll/{page}/{size}")
	@Cacheable(value = "userList")
	public List<User> findAll(@PathVariable int page,@PathVariable int size) {
		return service.findAll(page, size);
	}
	
	@GetMapping(value = "/{id}")
	@Cacheable(value = "userList",key = "#id")
	public User find(@PathVariable int id) {
		return service.find(id);
	}
	
	@DeleteMapping(value = "/{id}")
	@CacheEvict(value = "userList",key = "#id")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
	
	@PostMapping(value = "/activateUser/{id}")
	@CacheEvict(value = "userList",key = "#id")
	public void activateUser(@PathVariable int id) {
		service.activateUser(id);
	}

}
