package com.example.smartfixsystem.service;

import com.example.smartfixsystem.entity.Intervention;
import com.example.smartfixsystem.repository.InterventionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionService {

    private final InterventionRepository repo;

    public InterventionService(InterventionRepository repo) {
        this.repo = repo;
    }

    public List<Intervention> getAll() {
        return repo.findAll();
    }

    public Intervention save(Intervention i) {
        return repo.save(i);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}