package com.example.ifsp.controller;

import com.example.ifsp.dto.UsuarioDTO;
import com.example.ifsp.model.DadosLogin;
import com.example.ifsp.model.DadosUsuario;
import com.example.ifsp.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5500")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session) {
        if (usuarioService.authenticate(email, password)) {
            session.setAttribute("adminUser", email);
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();  // Remove todos os atributos da sessão
        return ResponseEntity.ok("Logout realizado com sucesso");
    }

    @GetMapping("/dashboard")
    public ResponseEntity<String> dashboard(HttpSession session) {
        System.out.println(session.getAttribute("adminUser"));
        if (session.getAttribute("adminUser") != null) {
            return ResponseEntity.ok("Bem-vindo, Administrador!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Não autenticado");
        }
    }

    @PutMapping ("/remove/{id}")
    public ResponseEntity<UsuarioDTO> remove(@PathVariable Long id) {
        usuarioService.removerDado(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updateEmail/{id}/{email}")
    public ResponseEntity<UsuarioDTO> updateEmail(@PathVariable Long id, @PathVariable String email) {
        usuarioService.updateEmail(id, email);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updatePassword/{id}/{oldpassword}/{newpassword}")
    public ResponseEntity<UsuarioDTO> updatePassword(@PathVariable Long id, @PathVariable String oldpassword, @PathVariable String newpassword) {
        usuarioService.updatePassword(id, oldpassword, newpassword);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cadastrarAdmin")
    public ResponseEntity<DadosUsuario> cadastrarAdmin(@RequestBody DadosUsuario dadosAdministrador){
        usuarioService.cadastrarAnimal(dadosAdministrador);
        return ResponseEntity.noContent().build();
    }
}
