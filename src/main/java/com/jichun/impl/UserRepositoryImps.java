package com.jichun.impl;

import org.springframework.stereotype.Repository;

import com.jichun.beans.UserRepository;

@Repository("userRepository")
public class UserRepositoryImps implements UserRepository {

	public void save() {
		System.out.println("UserRepositoryImps save");
	}

}
