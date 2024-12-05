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

import com.example.demo.entities.Cliente;  // Alterado para Cliente
import com.example.demo.services.ClienteService;  // Alterado para ClienteService

@RestController
@RequestMapping("/cliente")  
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/home")
    public String paginaInicial() {
        return "index";  // Página inicial (opcional)
    }

    // Criar um novo cliente
    @PostMapping("/create")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);  // Salvando Cliente
    }

    // Obter cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);  // Buscando por ID
        if (cliente != null) {
            return ResponseEntity.ok(cliente);  // Retorna 200 OK com o cliente encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 caso não encontre
        }
    }

    // Obter todos os clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();  // Buscando todos os clientes
    }

    // Excluir um cliente
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);  // Deletando o cliente
    }
}
