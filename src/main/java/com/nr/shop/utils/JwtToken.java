package com.nr.shop.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtToken {
	
	private static String secrateKey="Ganpatti@Bappa_Morya";

	private static Claims extractAlIClaims(String token) throws Exception {
		return Jwts.parser().setSigningKey(secrateKey).parseClaimsJws(token).getBody();
	}

	private static Boolean isTokenExpired(String token) throws Exception{
		return extractExpiration(token).after(new Date(System.currentTimeMillis()));
	}
	
	private static String createToken(HashMap<String, Object> claims, String username) {
		return Jwts.builder().setClaims(claims)
				             .setSubject(username)
				             .setIssuedAt(new Date(System.currentTimeMillis()))
				             .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*1))//setting Token Expiration time 1 hour
				             .signWith(SignatureAlgorithm.HS256, secrateKey)
				             .compact();
	}
	
	//If required to get Other details
	public static <T> T extractClaim(String token, Function<Claims, T> clainsResolver) throws Exception { 
		final Claims claims =extractAlIClaims(token); 
		return clainsResolver.apply(claims);
	}

	public static String generateToken(UserDetails user) {
		HashMap<String, Object> claims=new HashMap<>();
		/*
		 * claims.put("id", user.getId()); claims.put("fullName", user.getFull_name());
		 * claims.put("role", user.getRole()); claims.put("mobile", user.getMobile());
		 */
		return createToken(claims,user.getUsername());
	}
	
	public static Boolean validateToken(String token,String user) throws Exception {
		final String username = extractUsernane(token); 
		return (username.equals(user) && isTokenExpired(token)); 
	}
	
	public static String extractUsernane (String token) throws Exception { 
		return extractClaim(token, Claims::getSubject); 
	}
	
	public static Date extractIssuedTime(String token) throws Exception { 
		return extractClaim(token, Claims::getIssuedAt); 
	}
	
	public static Date extractCurrentTime()  throws Exception { 
		return new Date(System.currentTimeMillis()); 
	}

	public static Date extractExpiration(String token) throws Exception { 
		return extractClaim(token, Claims::getExpiration); 
	}

}
