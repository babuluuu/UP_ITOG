package com.example.springmodels.models;

import javax.persistence.*;

@Entity
@Table(name = "Tattoo_Type")
public class TattooType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Tattoo_Type")
    private Long id;

    @Column(name = "Type_Name", nullable = false)
    private String typeName;

    // Геттеры и сеттеры
}
