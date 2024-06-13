package com.br.depen.apidepen.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.depen.apidepen.model.Protocolo;
import com.br.depen.apidepen.service.ProtocoloService;

@RestController
@RequestMapping("api/v1/logins")
public class ProtocoloController {
	@Autowired
    private ProtocoloService protocoService;

    @GetMapping
    public ResponseEntity<List<Protocolo>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(protocoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Protocolo>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(protocoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Protocolo> create(@RequestBody Protocolo protocolo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(protocoService.save(protocolo));
    }

    @PutMapping
    public ResponseEntity<Protocolo> update(@RequestBody Protocolo protocolo) {
        return ResponseEntity.status(HttpStatus.OK).body(protocoService.update(protocolo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
    	protocoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
