package com.br.depen.apidepen.repository;

import com.br.depen.apidepen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
