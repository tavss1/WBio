package com.example.ifsp.repository;

import com.example.ifsp.model.Filo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiloRepository extends JpaRepository<Filo, Long> {

    Filo findFirstByNomeFiloContainingIgnoreCase(String nomeFilo);
}
