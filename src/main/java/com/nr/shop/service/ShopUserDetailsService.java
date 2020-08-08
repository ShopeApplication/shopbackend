package com.nr.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nr.shop.dao.UserDao;
import com.nr.shop.entity.ShopUserDetails;
import com.nr.shop.entity.User;

@Service
public class ShopUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao dao;

	@Override
	@Cacheable(value = "userList",key = "#username")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=null;
		if(username.contains("@") || username.contains(".")) {
			user = dao.findByEmail(username);
			return new ShopUserDetails(user.getPassword(),null,user.getEmail(),user.getRole(),user.getStatus());
		}else {	
		   user = dao.findByMobile(username);
		   return new ShopUserDetails(user.getPassword(),user.getMobile(),null,user.getRole(),user.getStatus());
		}
	}

}
