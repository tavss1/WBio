package com.example.ifsp.service;

import com.example.ifsp.dto.AdministradorDTO;
import com.example.ifsp.model.Administrador;
import com.example.ifsp.model.DadosAdministrador;
import com.example.ifsp.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    AdministradorRepository administradorRepository;


    public AdministradorDTO verifylogin(String email, String senha) {
        return converteDado(administradorRepository.findByEmailAndSenha(email, senha));
    }

    public void removerDado(Long id){
        administradorRepository.delete(administradorRepository.findById(id).map(a -> new Administrador(a.getNome(), a.getEmail(), a.getLattes(), a.getSenha())).orElse(null));
    }

    public AdministradorDTO converteDado(Administrador a) {
        return new AdministradorDTO(a.getId(), a.getNome(), a.getEmail(), a.getLattes());
    }

    public void updateEmail(Long id, String email) {
        administradorRepository.findById(id).ifPresent(a -> {
            a.setEmail(email);
            administradorRepository.save(a);
        });
    }

    public void updatePassword(Long id, String oldpassword, String newpassword) {
        administradorRepository.findById(id).ifPresent(a -> {
            if(a.getSenha().equals(oldpassword)) {
                a.setSenha(newpassword);
            }
            else{
            }
        });
    }

    public void cadastrarAnimal(DadosAdministrador dadosAdministrador) {
        Administrador administrador = new Administrador(dadosAdministrador.nome(), dadosAdministrador.email(), dadosAdministrador.lattes(), dadosAdministrador.senha());
        administradorRepository.save(administrador);
    }
}
