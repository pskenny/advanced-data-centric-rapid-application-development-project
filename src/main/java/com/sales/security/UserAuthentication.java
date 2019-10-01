package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Restrict access to URLs unless authenticated.
 * Given in lecture notes.
 * @author Paul Kenny
 *
 */
@EnableWebSecurity
public class UserAuthentication extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		// Don't allow unauthorised access to these URLs (i.e. all that are not the
		// index, see
		// section 6.9 in project specification)
		httpSecurity.authorizeRequests().antMatchers("/addBook", "/addCustomer", "/addLoan", "/deleteLoan",
				"/showBooks", "/showCustomers", "/showLoans").hasRole("USER").and().formLogin();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// User and password set t0 "user" and "user". See project specification section
		// 6.9
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
}