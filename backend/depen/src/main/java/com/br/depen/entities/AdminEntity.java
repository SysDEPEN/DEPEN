package com.br.depen.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_admin")
public class AdminEntity {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	
	@Column( name = "nome")
	private String name;
	
	@Column( name = "documento")
	private String document;
	
	@Column( name = "email")
	private String email;
	
	@Column( name = "senha")
	private String password;
	
	@Column( name = "role")
	private int role;
	
	@Column( name = "created_at")
	private LocalDateTime created_at;
	
	@Column( name = "updated_at")
	private LocalDateTime updated_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public AdminEntity(Long id, String name, String document, String email, String password, int role,
			LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.document = document;
		this.email = email;
		this.password = password;
		this.role = role;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
}
