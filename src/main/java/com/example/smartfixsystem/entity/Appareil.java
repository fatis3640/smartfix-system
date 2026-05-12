package com.example.smartfixsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Appareil {

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String marque;

    @ManyToOne
    private Client client;

    // getters & setters
}