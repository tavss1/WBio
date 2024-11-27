package com.example.ifsp.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTaxonomia(@JsonAlias("phylum") String filo,
                             @JsonAlias("class") String classe,
                             @JsonAlias("order") String ordem,
                             @JsonAlias("family") String familia,
                             @JsonAlias("genus") String genero,
                             @JsonAlias("scientific_name") String nomeCientifico) {
}
