package com.example.ifsp.model;

import jakarta.persistence.*;

@Entity
@Table(name="ordem")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome_ordem", nullable=false)
    private String nomeOrdem;

    @ManyToOne
    @JoinColumn(name = "classe_id", nullable = false)
    private Classe classe;

    public Ordem(String nomeOrdem, Classe classe) {
        this.nomeOrdem = nomeOrdem;
        this.classe = classe;
    }

    public Ordem() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeOrdem() {
        return nomeOrdem;
    }

    public void setNomeOrdem(String nomeOrdem) {
        this.nomeOrdem = nomeOrdem;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
