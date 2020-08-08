package com.nr.shop.service;

import java.util.List;

import com.nr.shop.entity.User;

public interface UserService {

	User create(User user);

	List<User> findAll(int page, int size);

	User find(int id);

	void delete(int id);
	
	void activateUser(int id);
	
	User findByMobile(String mobile);

	User findByEmail(String email);

}
