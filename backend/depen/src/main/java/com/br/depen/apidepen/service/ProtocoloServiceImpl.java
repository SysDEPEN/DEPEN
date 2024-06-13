package com.br.depen.apidepen.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.depen.apidepen.model.Protocolo;
import com.br.depen.apidepen.repository.ProtocoloRepository;

@Service
public class ProtocoloServiceImpl implements ProtocoloService{
	@Autowired
    private ProtocoloRepository protocoloRepository;

    @Override
    public Protocolo save(Protocolo protocolo) {
        return protocoloRepository.save(protocolo);
    }

    @Override
    public List<Protocolo> findAll() {
        return protocoloRepository.findAll();
    }

    @Override
    public Optional<Protocolo> findById(Long id) {
        return protocoloRepository.findById(id);
    }

    @Override
    public Protocolo update(Protocolo protocolo) {
        return protocoloRepository.save(protocolo);
    }

    @Override
    public void deleteById(Long id) {
    	protocoloRepository.deleteById(id);
    }
}
