package com.example.ifsp.service;

import com.example.ifsp.dto.UsuarioDTO;
import com.example.ifsp.model.DadosLogin;
import com.example.ifsp.model.DadosUsuario;
import com.example.ifsp.model.Usuario;
import com.example.ifsp.repository.UsuarioRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public UsuarioDTO verifylogin(DadosLogin dadosLogin) {
        return converteDado(usuarioRepository.findByEmailAndSenha(dadosLogin.email(), dadosLogin.senha()));
    }

    public void removerDado(Long id){
        usuarioRepository.delete(usuarioRepository.findById(id).map(a -> new Usuario(a.getNome(), a.getEmail(), a.getLattes(), a.getSenha(), a.getPerfil())).orElse(null));
    }

    public UsuarioDTO converteDado(Usuario a) {
        return new UsuarioDTO(a.getId(), a.getNome(), a.getEmail(), a.getLattes(), a.getPerfil());
    }

    public void updateEmail(Long id, String email) {
        usuarioRepository.findById(id).ifPresent(a -> {
            a.setEmail(email);
            usuarioRepository.save(a);
        });
    }

    public boolean authenticate(String email, String senha) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.isPresent() && usuario.get().getSenha().equals(senha); // Usando hash é mais seguro

    }

    public void updatePassword(Long id, String oldpassword, String newpassword) {
        usuarioRepository.findById(id).ifPresent(a -> {
            if(a.getSenha().equals(oldpassword)) {
                a.setSenha(newpassword);
            }
            else{
            }
        });
    }

    public void cadastrarAnimal(DadosUsuario dadosUsuario) {
        Usuario administrador = new Usuario(dadosUsuario.nome(), dadosUsuario.email(), dadosUsuario.lattes(), dadosUsuario.senha(), dadosUsuario.perfil());
        usuarioRepository.save(administrador);
    }
}
