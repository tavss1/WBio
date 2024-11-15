package com.example.ifsp.repository;

import com.example.ifsp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmailAndSenha(String email, String senha);

    Optional<Usuario> findByEmail(String email);
}
