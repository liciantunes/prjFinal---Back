package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Vendedor;  // Alterado para Vendedor
import com.example.demo.services.VendedorService;  // Alterado para VendedorService

@RestController
@RequestMapping("/vendedor")  // Alterado para /vendedor
public class VendedorController {

    private final VendedorService vendedorService;  // Alterado para VendedorService

    @Autowired
    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping("/home")
    public String paginaInicial() {
        return "index";  // Página inicial (opcional)
    }

    // Criar um novo vendedor
    @PostMapping("/create")
    public Vendedor createVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.saveVendedor(vendedor);  // Salvando Vendedor
    }

    // Obter vendedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> getVendedor(@PathVariable Long id) {
        Vendedor vendedor = vendedorService.getVendedorById(id);  // Buscando por ID
        if (vendedor != null) {
            return ResponseEntity.ok(vendedor);  // Retorna 200 OK com o vendedor encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 caso não encontre
        }
    }

    // Obter todos os vendedores
    @GetMapping
    public List<Vendedor> getAllVendedores() {
        return vendedorService.getAllVendedores();  // Buscando todos os vendedores
    }

    // Excluir um vendedor
    @DeleteMapping("/{id}")
    public void deleteVendedor(@PathVariable Long id) {
        vendedorService.deleteVendedor(id);  // Deletando o vendedor
    }
}
