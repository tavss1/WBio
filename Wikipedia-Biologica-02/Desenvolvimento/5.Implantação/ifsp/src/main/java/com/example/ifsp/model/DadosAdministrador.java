package com.example.ifsp.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAdministrador(
        @JsonAlias("nome") String nome,
        @JsonAlias("email") String email,
        @JsonAlias("lattes") String lattes,
        @JsonAlias("senha") String senha
        ) {
}
