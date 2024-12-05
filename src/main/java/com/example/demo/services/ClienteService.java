package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;  // Alterado para Cliente
import com.example.demo.repositories.ClienteRepository;  // Alterado para ClienteRepository

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;  // Alterado para ClienteRepository

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Preparando as buscas por id
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);  // Alterado para Cliente
    }

    // Preparando a busca geral
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();  // Alterado para Cliente
    }

    // Salvando o Cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);  // Alterado para Cliente
    }

    // Excluindo o Cliente
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);  // Alterado para Cliente
    }

    // Método para buscar Cliente por email e senha
    public Cliente findByEmailAndSenha(String email, String senha) {
        return clienteRepository.findByEmailAndSenha(email, senha);  // Alterado para Cliente
    }

}
