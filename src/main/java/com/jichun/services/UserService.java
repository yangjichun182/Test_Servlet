package com.jichun.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jichun.beans.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save() {
		userRepository.save();
	}
}
