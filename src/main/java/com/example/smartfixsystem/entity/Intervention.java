package com.example.smartfixsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class Intervention {

    @Id
    @GeneratedValue
    private Long id;

    private String details;
    private Date date;

    @ManyToOne
    private Demande demande;

    // getters & setters
}