package com.danielnunesro.springjwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.danielnunesro.springjwt.repositories.UserRepository;

@Service
public class UserServices implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	public UserServices(UserRepository repository) {
		this.repository = repository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repository.findByUsername(username);
		if(user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("Username: " + username + " not found.");
		}
	}
	
	
	
}
