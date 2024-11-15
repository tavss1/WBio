package com.example.ifsp.dto;

import com.example.ifsp.model.Perfil;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String escolaridade,
        Perfil perfil) {
}
