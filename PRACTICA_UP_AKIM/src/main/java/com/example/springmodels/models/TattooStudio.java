package com.example.springmodels.models;

import javax.persistence.*;

@Entity
@Table(name = "Tattoo_Studio")
public class TattooStudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Tattoo_Studio")
    private Long id;

    @Column(name = "Studio_Name", nullable = false)
    private String studioName;

    @Column(name = "Location", nullable = false)
    private String location;

    // Геттеры и сеттеры
}
