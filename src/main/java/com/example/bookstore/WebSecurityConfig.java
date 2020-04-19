package com.example.bookstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.bookstore.web.UsrDetServImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsrDetServImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/css/**").permitAll()
		.and()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/booklist")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/*
	@SuppressWarnings("deprecation")
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<UserDetails>();
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("user")
				.roles("USER")
				.build();
		
		users.add(user);
		
		user = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("USER", "ADMIN")
				.build();
		
		users.add(user);
		
		return new InMemoryUserDetailsManager(users);
	}
	*/

}
