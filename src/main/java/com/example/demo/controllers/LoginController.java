package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cliente;  // Alterado para Cliente
import com.example.demo.services.ClienteService;  // Alterado para ClienteService

@RestController
@RequestMapping("/login")
public class LoginController {

    private final ClienteService clienteService;  // Alterado para ClienteService

    @Autowired
    public LoginController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String senha = loginRequest.getSenha();

        // Verifica se é um cliente
        Cliente cliente = clienteService.findByEmailAndSenha(email, senha);  // Alterado para Cliente
        if (cliente != null) {
            return ResponseEntity.ok("Cliente logado com sucesso!");  // Pode retornar um token ou outra informação
        }

        return ResponseEntity.status(401).body("Credenciais inválidas.");  // Retorna 401 se as credenciais forem inválidas
    }

    // Classe auxiliar para receber os dados de login
    public static class LoginRequest {
        private String email;
        private String senha;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }
}
