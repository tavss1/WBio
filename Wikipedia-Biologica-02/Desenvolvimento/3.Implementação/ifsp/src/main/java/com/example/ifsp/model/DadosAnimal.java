package com.example.ifsp.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAnimal(@JsonAlias("name") String nome,
                          @JsonAlias("taxonomy") DadosTaxonomia taxonomia,
                          @JsonAlias("characteristics") DadosCaracteristicas caracteristicas)
{
}
