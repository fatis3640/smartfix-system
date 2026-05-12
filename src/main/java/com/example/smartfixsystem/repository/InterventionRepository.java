package com.example.smartfixsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartfixsystem.entity.Intervention;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {
}