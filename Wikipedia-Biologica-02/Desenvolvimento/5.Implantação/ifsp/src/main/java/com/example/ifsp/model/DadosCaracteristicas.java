package com.example.ifsp.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCaracteristicas(@JsonAlias("habitat") String habitat,
                                   @JsonAlias("diet") String alimentacao,
                                   @JsonAlias("weight") String peso) {
}
