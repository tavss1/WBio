package com.example.ifsp.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAnimal2(
        @JsonAlias("nomePopular") String nomePopular,
        @JsonAlias("habitat") String habitat,
        @JsonAlias("alimentacao") String alimentacao,
        @JsonAlias("peso") String peso,
        @JsonAlias("filo") String filo,
        @JsonAlias("classe") String classe,
        @JsonAlias("ordem") String ordem,
        @JsonAlias("familia") String familia,
        @JsonAlias("genero") String genero,
        @JsonAlias("especie") String especie,
        @JsonAlias("descricao") String descricao,
        @JsonAlias("imagem") String imagem) {
}
