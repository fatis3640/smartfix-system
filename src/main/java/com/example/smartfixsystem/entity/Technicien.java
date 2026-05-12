package com.example.smartfixsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Technicien {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String speciality;

    // getters & setters
}

