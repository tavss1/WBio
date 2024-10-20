package com.example.ifsp.repository;

import com.example.ifsp.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero, Long> {

    Genero findFirstByNomeGeneroContainingIgnoreCase(String nomeGenero);
}
