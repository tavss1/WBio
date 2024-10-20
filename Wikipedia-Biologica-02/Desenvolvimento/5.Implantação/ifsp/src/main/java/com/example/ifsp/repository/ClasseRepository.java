package com.example.ifsp.repository;

import com.example.ifsp.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

    Classe findFirstByNomeClasseContainingIgnoreCase(String nome);
}
