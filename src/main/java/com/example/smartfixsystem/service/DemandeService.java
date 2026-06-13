package com.example.smartfixsystem.service;

import com.example.smartfixsystem.entity.Demande;
import com.example.smartfixsystem.entity.Status;
import com.example.smartfixsystem.repository.DemandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {

    private final DemandeRepository repo;

    public DemandeService(DemandeRepository repo) {
        this.repo = repo;
    }

    public List<Demande> getAll() {
        return repo.findAll();
    }

    public Demande save(Demande demande) {
        return repo.save(demande);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Demande> getByStatus(Status status) {
        return repo.findByStatus(status);
    }

    public Demande getById(Long id) {
        Optional<Demande> demande = repo.findById(id);
        return demande.orElse(null);
    }
}