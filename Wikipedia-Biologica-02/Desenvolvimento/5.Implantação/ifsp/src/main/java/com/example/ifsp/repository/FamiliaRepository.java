package com.example.ifsp.repository;

import com.example.ifsp.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
    Familia findFirstByNomeFamiliaContainingIgnoreCase(String nomeFamilia);
}
