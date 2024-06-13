package com.br.depen.apidepen.service;

import com.br.depen.apidepen.model.Login;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    Login save(Login login);

    List<Login> findAll();

    Optional<Login> findById(Long id);

    Login update (Login login);

    void deleteById(Long id);
}
