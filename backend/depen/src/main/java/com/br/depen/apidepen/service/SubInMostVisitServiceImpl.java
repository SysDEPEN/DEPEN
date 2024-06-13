package com.br.depen.apidepen.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.depen.apidepen.model.SubInMostVisit;
import com.br.depen.apidepen.repository.SubInMostVisitRepository;

@Service
public class SubInMostVisitServiceImpl implements SubInMostVisitService{

    @Autowired
    private SubInMostVisitRepository subInMostVisitRepository;

    @Override
    public SubInMostVisit save(SubInMostVisit subInMostVisit) {
        return subInMostVisitRepository.save(subInMostVisit);
    }

    @Override
    public List<SubInMostVisit> findAll() {
        return subInMostVisitRepository.findAll();
    }

    @Override
    public Optional<SubInMostVisit> findById(Long id) {
        return subInMostVisitRepository.findById(id);
    }

    @Override
    public SubInMostVisit update(SubInMostVisit subInMostVisit) {
        return subInMostVisitRepository.save(subInMostVisit);
    }

    @Override
    public void deleteById(Long id) {
    	subInMostVisitRepository.deleteById(id);
    }
}