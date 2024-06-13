package com.br.depen.apidepen.repository;

import com.br.depen.apidepen.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByNome(String username);
}