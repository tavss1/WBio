package com.example.ifsp.dto;

import com.example.ifsp.model.Perfil;
import com.fasterxml.jackson.annotation.JsonAlias;

public record RegisterDTO(
        @JsonAlias("email") String email,
        @JsonAlias("password") String password,
        @JsonAlias("role") Perfil role,
        @JsonAlias("lattes") String lattes,
        @JsonAlias("nome") String nome ) {
}
