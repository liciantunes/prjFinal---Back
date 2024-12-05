package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente") 
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente; 
    private String nome;
    private String email;
    private String senha;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nome, String email, String senha) {
        super();
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    // Setters
    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
