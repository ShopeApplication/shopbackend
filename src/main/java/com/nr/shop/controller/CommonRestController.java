package com.nr.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nr.shop.dto.RequestBoby;
import com.nr.shop.entity.MaleProduct;
import com.nr.shop.entity.User;
import com.nr.shop.service.CartService;
import com.nr.shop.service.MaleProductService;
import com.nr.shop.service.MasterService;
import com.nr.shop.service.UserService;
import com.nr.shop.utils.JwtToken;
import com.nr.shop.utils.ShopBCryptPE;
import com.nr.shop.utils.ShopRegex;

import net.sf.json.JSONObject;

@CrossOrigin(origins = {"${ui.url}"},maxAge = 3600)
@RestController
@RequestMapping("/common")
public class CommonRestController {
	
	//This API will be called only by user having any role
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsService userdetailService;
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private MaleProductService maleproductservice;
	
	@Autowired
	MasterService masterservice;
	
	@Autowired
	private UserService userservice;
	
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
	
	@PostMapping(value = "/createUser")
	public ResponseEntity<String> createUser(@RequestBody RequestBoby rb) throws Exception {
		User user = new User();
		if(rb.getUsername().contains("@") || rb.getUsername().contains(".")) {
			//Username is Email
			if(ShopRegex.validateEmail(rb.getUsername())) {
				//Email is valid
				if(userservice.findByEmail(rb.getUsername()) != null) {
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
				if(userservice.findByMobile(rb.getUsername()) !=null) {
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
		User res=userservice.create(user);
		if(res != null) {
			//User created
			return new ResponseEntity<String>("Account Created", HttpStatus.OK);
		}
		//User not Created  
		return new ResponseEntity<String>("Failed to create user.", HttpStatus.OK);
	}

	
	//Master
	@GetMapping("/findCatagories")
	public JSONObject findCatagories(){
		try {
			return masterservice.findCatagories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Cart
	@PostMapping("addToCart")
	public int addToCart(@PathVariable int userId,@PathVariable int productId) {
		return cartservice.addToCart(userId, productId);
	}
	
	//Male
	@GetMapping(value = "/findAllMaleProduct/{page}/{size}")
	@Cacheable(value = "maleProducList")
	public List<MaleProduct> findAllMaleProduct(@PathVariable int page,@PathVariable int size) {
		return maleproductservice.findAll(page, size);
	}
	
	@GetMapping(value = "/findMaleProduct/{productId}")
	@Cacheable(value = "maleProducList",key = "#productId")
	public MaleProduct findMaleProduct(@PathVariable int productId) {
		return maleproductservice.find(productId);
	}
		

}
