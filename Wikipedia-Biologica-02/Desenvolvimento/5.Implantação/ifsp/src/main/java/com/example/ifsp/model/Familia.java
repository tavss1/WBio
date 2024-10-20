package com.example.ifsp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "familia")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_familia", nullable = false)
    private String nomeFamilia;

    @ManyToOne
    @JoinColumn(name = "ordem_id", nullable = false)
    private Ordem ordem;

    public Familia(String nomeFamilia, Ordem ordem) {
        this.nomeFamilia = nomeFamilia;
        this.ordem = ordem;
    }

    public Familia() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFamilia() {
        return nomeFamilia;
    }

    public void setNomeFamilia(String nomeFamilia) {
        this.nomeFamilia = nomeFamilia;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }
}
