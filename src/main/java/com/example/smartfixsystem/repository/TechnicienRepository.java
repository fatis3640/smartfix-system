package com.example.smartfixsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartfixsystem.entity.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
}