package com.br.depen.apidepen.service;

import java.util.List;
import java.util.Optional;
import com.br.depen.apidepen.model.Protocolo;

public interface ProtocoloService {

    Protocolo save(Protocolo protocolo);

    List<Protocolo> findAll();

    Optional<Protocolo> findById(Long id);

    Protocolo update (Protocolo protocolo);

    void deleteById(Long id);
}