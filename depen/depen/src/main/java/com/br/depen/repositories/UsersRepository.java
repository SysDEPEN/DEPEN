package com.br.depen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.depen.entities.UserEntity;
@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

}
