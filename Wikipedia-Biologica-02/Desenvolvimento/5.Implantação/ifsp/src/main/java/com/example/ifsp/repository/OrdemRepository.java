package com.example.ifsp.repository;

import com.example.ifsp.model.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemRepository extends JpaRepository<Ordem, Long> {

    Ordem findFirstByNomeOrdemContainingIgnoreCase(String nome);
}
