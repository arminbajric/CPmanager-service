package com.cpmanager.service.impl;



import com.cpmanager.service.repositories.UserRepository;
import com.cpmanager.service.service.UserService;
import com.cpmanager.service.tableModels.UserTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserTableModel user = userRepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public UserTableModel save(UserTableModel user) {
		return null;
	}

	public List findAll() {
		List<UserTableModel> list = new ArrayList<>();
		return userRepository.findAll();

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public UserTableModel findOne(String username) {
		return null;
	}

	@Override
	public UserTableModel findById(int id) {
		return null;
	}

	@Override
	public UserTableModel update(UserTableModel userDto) {
		return null;
	}


}
