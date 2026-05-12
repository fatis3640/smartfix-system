package com.example.smartfixsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Demande {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Appareil appareil;

    @ManyToOne
    private Technicien technicien;

    // getters & setters
}
