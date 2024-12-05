package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Vendedor;  // Alterado para Vendedor
import com.example.demo.repositories.VendedorRepository;  // Alterado para VendedorRepository

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;  // Alterado para VendedorRepository

    @Autowired
    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    // Preparando as buscas por id
    public Vendedor getVendedorById(Long id) {
        return vendedorRepository.findById(id).orElse(null);  // Alterado para Vendedor
    }

    // Preparando a busca geral
    public List<Vendedor> getAllVendedores() {
        return vendedorRepository.findAll();  // Alterado para Vendedor
    }

    // Salvando o Vendedor
    public Vendedor saveVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);  // Alterado para Vendedor
    }

    // Excluindo o Vendedor
    public void deleteVendedor(Long id) {
        vendedorRepository.deleteById(id);  // Alterado para Vendedor
    }

    // Método para buscar Vendedor por email e senha
    public Vendedor findByEmailAndSenha(String email, String senha) {
        return vendedorRepository.findByEmailAndSenha(email, senha);  // Alterado para Vendedor
    }

}
