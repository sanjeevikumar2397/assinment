package com.te.doctorflow1.securityandjwtconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.te.doctorflow1.jwtfilter.DoctorDetailsJWTFilter;

@Configuration
@EnableWebSecurity
public class AuthenticationSecurityConfiguration {
	
	@Autowired
	private DoctorDetailsJWTFilter detailsJWTFilter;
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
//	@Bean
//	PasswordEncoder encoder() {
//		//return NoOpPasswordEncoder.getInstance();
//	}
//	
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		//.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
		.requestMatchers("/ApplyLeave/{name}").hasRole("DOCTOR")
		.requestMatchers("/appoinmentList/{name}").hasRole("DOCTOR")
		.requestMatchers("/addDoctor").permitAll()
		.requestMatchers("/login").permitAll()
		.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll().anyRequest()
		.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(detailsJWTFilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
	

}
