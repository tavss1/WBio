package com.example.ifsp.model;

import jakarta.persistence.*;

@Entity
@Table(name="classe")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_classe", nullable = false)
    private String nomeClasse;

    @ManyToOne
    @JoinColumn(name = "filo_id", nullable = false)
    private Filo filo;

    public Classe(String nomeClasse, Filo filo) {
        this.nomeClasse = nomeClasse;
        this.filo = filo;
    }

    public Classe() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public Filo getFilo() {
        return filo;
    }

    public void setFilo(Filo filo) {
        this.filo = filo;
    }
}
