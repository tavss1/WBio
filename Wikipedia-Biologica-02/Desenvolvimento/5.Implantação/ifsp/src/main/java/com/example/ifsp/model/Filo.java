package com.example.ifsp.model;

import jakarta.persistence.*;

@Entity
@Table(name="filo")
public class Filo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome_filo", nullable = false)
    private String nomeFilo;

    public Filo() {}

    public Filo(String nomeFilo) {
        this.nomeFilo = nomeFilo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFilo() {
        return nomeFilo;
    }

    public void setNomeFilo(String nomeFilo) {
        this.nomeFilo = nomeFilo;
    }
}
