package com.te.doctorflow1.jwtfilter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.te.doctorflow1.securityandjwtutil.AuthenticationJwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class DoctorDetailsJWTFilter extends OncePerRequestFilter{
	
	@Autowired
	private AuthenticationJwtUtil authenticationJwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwt=null;
		String extractUserName=null;
		String header=request.getHeader("Authorization");
		if (header!=null&& header.startsWith("Bearer ")) {
		
			jwt=header.substring(7);
			extractUserName=authenticationJwtUtil.extractUsername(jwt);
		
//		jwt=header.substring(7);
//		extractUserName=authenticationJwtUtil.extractUsername(jwt);
//			
//			
			
		}
		
		if (extractUserName!=null&& SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails loadUserByUsername = userDetailsService.loadUserByUsername(extractUserName);
			
			
			
			if (authenticationJwtUtil.validateToken(jwt, loadUserByUsername)) {
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(null, loadUserByUsername,loadUserByUsername.getAuthorities());
				token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(token);
				
				
			}
			
		}
		filterChain.doFilter(request, response);
		
		
	}

}
