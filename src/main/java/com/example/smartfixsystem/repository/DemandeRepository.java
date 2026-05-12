package com.example.smartfixsystem.repository;

import com.example.smartfixsystem.entity.Demande;
import com.example.smartfixsystem.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {

    List<Demande> findByStatus(Status status);

}