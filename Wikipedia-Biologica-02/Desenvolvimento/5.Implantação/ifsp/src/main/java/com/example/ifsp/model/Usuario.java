package com.example.ifsp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;
    private String email;
    private String lattes;
    private String senha;

    private Perfil perfil;

    public Usuario(String nome, String email, String lattes, String senha, Perfil perfil) {
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Usuario(Long id, String nome, String email, String lattes, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
        this.perfil = perfil;
    }

    public Usuario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
