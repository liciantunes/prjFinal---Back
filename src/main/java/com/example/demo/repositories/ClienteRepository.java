package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Cliente;  // Alterado para Cliente

public interface ClienteRepository extends JpaRepository<Cliente, Long> {  // Alterado para Cliente

    Cliente findByEmailAndSenha(String email, String senha);  // Método para buscar cliente por email e senha
}
