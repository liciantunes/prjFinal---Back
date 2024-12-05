package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long produtoId;

    private String produtoNome;
    private String produtoPreco;
    private int produtoEstoque;

    @Lob
    private byte[] thumbnail;

    // Novo campo para armazenar a imagem 
    private String produtoImagem;

    // Getters e setters
    public long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(String produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public int getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(int produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getProdutoImagem() {
        return produtoImagem;
    }

    public void setProdutoImagem(String produtoImagem) {
        this.produtoImagem = produtoImagem;
    }
}

