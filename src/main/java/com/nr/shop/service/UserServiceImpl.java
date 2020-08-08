package com.nr.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nr.shop.dao.UserDao;
import com.nr.shop.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	@Override
	public User create(User user) {
		return dao.save(user);
	}
	
	@Override
	public List<User> findAll(int page,int size) {
		Pageable pageable=PageRequest.of(page, size);
		return dao.findAll(pageable).toList();
	}

	@Override
	public User find(int id) {
		return dao.findById(id);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}
	
	@Override
	public void activateUser(int id) {
		dao.activateUser(id);
	}

	@Override
	public User findByMobile(String mobile) {
		return dao.findByMobile(mobile);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

}
