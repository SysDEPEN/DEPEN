package com.br.depen.apidepen.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String subject;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
}