package com.pactera.impl;

import org.springframework.stereotype.Repository;

import com.pactera.beans.UserRepository;

@Repository("userRepository")
public class UserRepositoryImps implements UserRepository {

	public void save() {
		System.out.println("UserRepositoryImps save");
	}

}
