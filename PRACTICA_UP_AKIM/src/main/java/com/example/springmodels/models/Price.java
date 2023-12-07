package com.example.springmodels.models;

import javax.persistence.*;

@Entity
@Table(name = "Price_tatu")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Price_tatu")
    private Long id;

    @Column(name = "Price", nullable = false)
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
