package com.br.depen.apidepen.repository;

import com.br.depen.apidepen.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
