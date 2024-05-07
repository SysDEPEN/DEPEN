package com.br.depen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.depen.entities.AdminEntity;
import com.br.depen.repositories.AdminRepository;

@Service
public class AdminService {
@Autowired
private AdminRepository repository;
	
	public List<AdminEntity> FindAll() {
		return repository.findAll();
	}

}
