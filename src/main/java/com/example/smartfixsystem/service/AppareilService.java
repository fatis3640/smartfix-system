package com.example.smartfixsystem.service;

import com.example.smartfixsystem.entity.Appareil;
import com.example.smartfixsystem.repository.AppareilRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppareilService {

    private final AppareilRepository repo;

    public AppareilService(AppareilRepository repo) {
        this.repo = repo;
    }

    public List<Appareil> getAll() {
        return repo.findAll();
    }

    public Appareil save(Appareil appareil) {
        return repo.save(appareil);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Appareil getById(Long id) {
        Optional<Appareil> appareil = repo.findById(id);
        return appareil.orElse(null);
    }
}