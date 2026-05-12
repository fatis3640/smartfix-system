package com.example.smartfixsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.smartfixsystem.entity.Appareil;

public interface AppareilRepository extends JpaRepository<Appareil, Long> {
}