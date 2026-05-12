package com.example.smartfixsystem.service;

import com.example.smartfixsystem.entity.Appareil;
import com.example.smartfixsystem.repository.AppareilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppareilService {

    private final AppareilRepository repo;

    public AppareilService(AppareilRepository repo) {
        this.repo = repo;
    }

    public List<Appareil> getAll() {
        return repo.findAll();
    }

    public Appareil save(Appareil a) {
        return repo.save(a);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}