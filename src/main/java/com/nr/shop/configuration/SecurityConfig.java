package com.nr.shop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private ShopJwtRequestFilter JwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.csrf().disable()
	    .authorizeRequests().antMatchers("/master/findAll","/master/findCatagories","/user/createUser","/male/findAll/**","/male/find/**","/cart/**","/user/authenticate/**").permitAll()
	                        .antMatchers("/master/adminHeader").hasAnyAuthority("ADMIN","DISTRIBUTER")
	                        .anyRequest().authenticated()
	                        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    http.addFilterBefore(JwtRequestFilter,  UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	       return super.authenticationManagerBean();
	}   

}
