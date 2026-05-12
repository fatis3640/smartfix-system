package com.example.smartfixsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartfixsystem.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}