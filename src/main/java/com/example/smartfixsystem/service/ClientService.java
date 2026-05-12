package com.example.smartfixsystem.service;

import com.example.smartfixsystem.entity.Client;
import com.example.smartfixsystem.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public List<Client> getAll() {
        return repo.findAll();
    }

    public Client save(Client c) {
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}