package com.example.ifsp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private String lattes;
    private String senha;

    public Administrador(String nome, String email, String lattes, String senha) {
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
        this.senha = senha;
    }

    public Administrador() {}

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
