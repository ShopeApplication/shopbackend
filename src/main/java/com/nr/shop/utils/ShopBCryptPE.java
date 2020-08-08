package com.nr.shop.utils;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ShopBCryptPE{
	
	public static String encrypt(String rawPassword) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(15, new SecureRandom());
		return encoder.encode(rawPassword);
	}

}
