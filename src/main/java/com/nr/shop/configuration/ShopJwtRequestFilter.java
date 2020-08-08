package com.nr.shop.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nr.shop.utils.JwtToken;

@Component
public class ShopJwtRequestFilter extends OncePerRequestFilter  {
	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authData=request.getHeader("Authorization");
		String jwt=null;
		String username=null;
		if(authData !=null &&authData.startsWith("Bearer ")) {
			jwt=authData.substring(7);
			try {
				username=JwtToken.extractUsernane(jwt);
			} catch (Exception e) {
				System.out.println("Invalid token");
				e.printStackTrace();
			}
		}
		if(username !=null ) {
			UserDetails userdetails=userDetailService.loadUserByUsername(username);
			try {
				if(JwtToken.validateToken(jwt, userdetails.getUsername()) && SecurityContextHolder.getContext().getAuthentication() ==null) {
					UsernamePasswordAuthenticationToken usernamepasswordauthentication =new UsernamePasswordAuthenticationToken(
							                                userdetails.getPassword(), userdetails.getPassword(), userdetails.getAuthorities());
					usernamepasswordauthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamepasswordauthentication);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		filterChain.doFilter(request, response);
	}


}
