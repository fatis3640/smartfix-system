package com.example.smartfixsystem.service;

import com.example.smartfixsystem.entity.Technicien;
import com.example.smartfixsystem.repository.TechnicienRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicienService {

    private final TechnicienRepository repo;

    public TechnicienService(TechnicienRepository repo) {
        this.repo = repo;
    }

    public List<Technicien> getAll() {
        return repo.findAll();
    }

    public Technicien save(Technicien t) {
        return repo.save(t);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}