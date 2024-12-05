package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Vendedor;  // Alterado para Cliente

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {  // Alterado para Cliente

    Vendedor findByEmailAndSenha(String email, String senha);  // Método para buscar cliente por email e senha
}
