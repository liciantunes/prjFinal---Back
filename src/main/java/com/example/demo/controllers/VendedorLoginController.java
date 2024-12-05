package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Vendedor;  // Alterado para Vendedor
import com.example.demo.services.VendedorService;  // Alterado para VendedorService

@RestController
@RequestMapping("/vendedor")  // Corrigido para "/vendedor"
public class VendedorLoginController {

    private final VendedorService vendedorService;  // Alterado para VendedorService

    @Autowired
    public VendedorLoginController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    // Endpoint para login do vendedor
    @PostMapping  // Este método aceitará requisições POST
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String senha = loginRequest.getSenha();

        // Verifica se o vendedor existe com o email e senha fornecidos
        Vendedor vendedor = vendedorService.findByEmailAndSenha(email, senha);  // Alterado para Vendedor
        if (vendedor != null) {
            return ResponseEntity.ok("Vendedor logado com sucesso!");  // Sucesso no login do vendedor
        }

        return ResponseEntity.status(401).body("Credenciais inválidas.");  // Retorna 401 caso as credenciais sejam inválidas
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
