package com.nr.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nr.shop.dao.UserMessageDao;
import com.nr.shop.entity.UserMessage;

@Service
public class UserMessageServiceImpl implements UserMessageService{
	
	@Autowired
	private UserMessageDao dao;

	@Override
	public int saveUserMessage(UserMessage user) {
		UserMessage userm=dao.save(user);
		if(userm != null)
			return 1;
		return 0;
	}

}
