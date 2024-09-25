package com.example.ifsp.controller;

import com.example.ifsp.dto.AdministradorDTO;
import com.example.ifsp.model.Administrador;
import com.example.ifsp.model.Animal;
import com.example.ifsp.model.DadosAdministrador;
import com.example.ifsp.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/login/{email}/{senha}")
    public AdministradorDTO login(@PathVariable String email, @PathVariable String senha) {
        return administradorService.verifylogin(email, senha);
    }

    @PutMapping ("/remove/{id}")
    public ResponseEntity<AdministradorDTO> remove(@PathVariable Long id) {
        administradorService.removerDado(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updateEmail/{id}/{email}")
    public ResponseEntity<AdministradorDTO> updateEmail(@PathVariable Long id, @PathVariable String email) {
        administradorService.updateEmail(id, email);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("updatePassword/{id}/{oldpassword}/{newpassword}")
    public ResponseEntity<AdministradorDTO> updatePassword(@PathVariable Long id, @PathVariable String oldpassword, @PathVariable String newpassword) {
        administradorService.updatePassword(id, oldpassword, newpassword);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cadastrarAdmin")
    public ResponseEntity<DadosAdministrador> cadastrarAdmin(@RequestBody DadosAdministrador dadosAdministrador){
        administradorService.cadastrarAnimal(dadosAdministrador);
        return ResponseEntity.noContent().build();
    }
}
