package com.vacinations.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication
		
		auth.inMemoryAuthentication()
			.withUser("patient").password("{noop}test123").roles("PATIENT")
			.and()
			.withUser("doctor").password("{noop}test123").roles("DOCTOR");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**").permitAll()
		.antMatchers("/vaccinations_patients/**").access("hasAnyRole('ROLE_PATIENT', 'ROLE_DOCTOR')")
		.and()
		.formLogin()
		.loginPage("/showMyLoginPage")
		.usernameParameter("username")
        .passwordParameter("password")
		.loginProcessingUrl("/authenicateTheUser")
		.defaultSuccessUrl("/vaccinations_patients/home")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	}
}