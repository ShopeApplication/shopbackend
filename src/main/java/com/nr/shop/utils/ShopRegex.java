package com.nr.shop.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopRegex {
	
	public static boolean validateEmail(final String email) {
		final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		return Pattern.compile(regex).matcher(email).matches();
	}
	
	public static boolean validateMobile(final String mobile) {
		final Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		final Matcher m = p.matcher(mobile); 
		return (m.find() && m.group().equals(mobile));
	}

}
