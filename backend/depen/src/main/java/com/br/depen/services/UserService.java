package com.br.depen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.depen.entities.UserEntity;
import com.br.depen.repositories.UsersRepository;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository repository;
	
	public List<UserEntity> FindAll() {
		return repository.findAll();
	}

	public UserEntity saveUser(UserEntity user) {
        return repository.save(user);
    }
	
}
