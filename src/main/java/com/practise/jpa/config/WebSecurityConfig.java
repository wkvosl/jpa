package com.practise.jpa.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//https://www.baeldung.com/security-spring

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.csrf().disable() // post 방식으로 값을 전송할 때 token을 사용해야하는 보안 설정을 해제
			.authorizeHttpRequests((requests)->requests
					.antMatchers("/","/home","/addmember","/board/free","/member").permitAll()
					.antMatchers("/board/write").hasRole("role_user")
					.anyRequest().authenticated()
					)
			.formLogin((form)->form
					.loginPage("/login")
					.permitAll()
					.loginProcessingUrl("/login2")
					.successHandler(
				                new AuthenticationSuccessHandler() {
									@Override
									public void onAuthenticationSuccess(HttpServletRequest request,
											HttpServletResponse response, Authentication authentication)
											throws IOException, ServletException {
										System.out.println("authentication : " + authentication.getName());
				                        response.sendRedirect("/"); 
									}
				                })
					)
			.logout((logout)->logout
					.logoutSuccessUrl("/")
					.deleteCookies("JSESSIONID")
					.permitAll()
					);
		return http.build();

	}
	//jdbc 
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    final String usernameQuery = "select username, password, enabled " //순서중요
	    								+ "from jpatest "
	    								+ "where username = ?";
	    final String authQuery = "select * from jpatest where username = ?";
	    auth.jdbcAuthentication()
	        .dataSource(dataSource)
	        .usersByUsernameQuery(usernameQuery)
	        .authoritiesByUsernameQuery(authQuery);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	

}
