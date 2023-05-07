package com.te.doctorflow1.securityjwtservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.te.doctorflow1.entity.DoctorDetails;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class MyUserDetailsService implements UserDetails{
	
	private DoctorDetails details;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(details.getRole());
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		authorities.add(authority);
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return details.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return details.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
