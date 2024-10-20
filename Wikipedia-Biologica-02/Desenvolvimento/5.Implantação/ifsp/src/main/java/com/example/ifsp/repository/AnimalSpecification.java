package com.example.ifsp.repository;

import com.example.ifsp.model.Animal;
import org.springframework.data.jpa.domain.Specification;

public class AnimalSpecification {

    public static Specification<Animal> hasGenero(String genero) {
        return (root, query, criteriaBuilder) ->
                genero == null ? null : criteriaBuilder.equal(root.get("genero").get("nomeGenero"), genero);
    }

    public static Specification<Animal> hasFamilia(String familia) {
        return (root, query, criteriaBuilder) ->
                familia == null ? null : criteriaBuilder.equal(root.get("genero").get("familia").get("nomeFamilia"), familia);
    }

    public static Specification<Animal> hasOrdem(String ordem) {
        return (root, query, criteriaBuilder) ->
                ordem == null ? null : criteriaBuilder.equal(root.get("genero").get("familia").get("ordem").get("nomeOrdem"), ordem);
    }

    public static Specification<Animal> hasClasse(String classe) {
        return (root, query, criteriaBuilder) ->
                classe == null ? null : criteriaBuilder.equal(root.get("genero").get("familia").get("ordem").get("classe").get("nomeClasse"), classe);
    }

    public static Specification<Animal> hasFilo(String filo) {
        return (root, query, criteriaBuilder) ->
                filo == null ? null : criteriaBuilder.equal(root.get("genero").get("familia").get("ordem").get("classe").get("filo").get("nomeFilo"), filo);
    }
}

