package com.br.depen.apidepen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cep;
	
	private String pais;
	
	private String UF;
	
	private String cidade;
	
	private String bairro;
	
	private String rua;
	
	@Column(name = "numero_casa")
	private String numeroCasa;
}
