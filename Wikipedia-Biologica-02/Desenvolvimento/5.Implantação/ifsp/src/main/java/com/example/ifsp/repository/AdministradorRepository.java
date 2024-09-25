package com.example.ifsp.repository;

import com.example.ifsp.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Administrador findByEmailAndSenha(String email, String senha);
}
