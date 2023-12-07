package com.example.springmodels.models;

import javax.persistence.*;

@Entity
@Table(name = "Color_tatu")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Color_tatu")
    private Long id;

    @Column(name = "Color", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
