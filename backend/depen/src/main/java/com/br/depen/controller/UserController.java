package com.br.depen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.depen.entities.UserEntity;
import com.br.depen.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> FindAll(){
		return ResponseEntity.ok(userService.FindAll());
	}
	
	@PostMapping
	public ResponseEntity<UserEntity> postUser(UserEntity user){
		UserEntity savedUser = userService.saveUser(user);
		return ResponseEntity.ok(savedUser);
	}
}
