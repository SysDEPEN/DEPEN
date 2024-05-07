package com.br.depen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.depen.entities.AdminEntity;
import com.br.depen.services.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public ResponseEntity<List<AdminEntity>> FindAll(){
		return ResponseEntity.ok(adminService.FindAll());
	}
}
