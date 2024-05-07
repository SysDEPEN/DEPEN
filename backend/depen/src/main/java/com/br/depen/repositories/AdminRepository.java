package com.br.depen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.depen.entities.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Long>{

}
