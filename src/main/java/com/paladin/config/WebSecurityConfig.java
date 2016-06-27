package com.paladin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.paladin.auth.StatelessAuthenticationFilter;
import com.paladin.auth.TokenAuthenticationService;
import com.paladin.services.UserService;
import com.paladin.util.PasswordCrypto;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;
	
	@Autowired
	private PasswordCrypto pwCrypto;

	public WebSecurityConfig() {
		super(true);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.exceptionHandling().and()
		.anonymous().and()
		.servletApi().and()
		.authorizeRequests()

		// Allow anonymous resource requests
		.antMatchers("/").permitAll()
		.antMatchers("/favicon.ico").permitAll()
		.antMatchers("/**/*.html").permitAll()
//		.antMatchers("/**/*.css").permitAll()
//		.antMatchers("/**/*.js").permitAll()
//		.antMatchers("/**/*.jpg").permitAll()
//		.antMatchers("/**/*.jpeg").permitAll()
//		.antMatchers("/**/*.png").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/app/**").permitAll()
		// Allow anonymous logins
		.antMatchers("/auth/**").permitAll()
		.antMatchers("/opportunity/**").permitAll()
		.antMatchers("/enterprises/**").permitAll()
		// All other request need to be authenticated
		.anyRequest().authenticated().and()

		// Custom Token based authentication based on the header previously given to the client
		.addFilterBefore(new StatelessAuthenticationFilter(tokenAuthenticationService), UsernamePasswordAuthenticationFilter.class)
		.headers().cacheControl().and();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(pwCrypto.getEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
