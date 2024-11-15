package com.example.ifsp.model;

public enum Perfil {
    ADMIN("admin"),
    CURADOR("curador");

    private String perfil;

    Perfil(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil(){
        return perfil;
    }
}
