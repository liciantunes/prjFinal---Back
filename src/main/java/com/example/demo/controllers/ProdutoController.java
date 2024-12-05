package com.example.demo.controllers;

import com.example.demo.entities.Produto;
import com.example.demo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")  // Permite requisições do frontend
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Endpoint para listar todos os produtos
    @GetMapping("/listar")
    public List<Produto> listarProdutos() {
        return produtoService.getAllProdutos();
    }

    // Endpoint para criar um novo produto
    @PostMapping("/create")
    public ResponseEntity<Produto> createProduto(@RequestParam("produtoNome") String produtoNome,
                                                 @RequestParam("produtoPreco") String produtoPreco,
                                                 @RequestParam("produtoEstoque") int produtoEstoque,
                                                 @RequestParam("thumbnail") MultipartFile thumbnail) throws IOException {
        Produto produto = produtoService.createProduto(produtoNome, produtoPreco, produtoEstoque, thumbnail);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um produto
    @PutMapping("/update/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id,
                                                 @RequestParam("produtoNome") String produtoNome,
                                                 @RequestParam("produtoPreco") String produtoPreco,
                                                 @RequestParam("produtoEstoque") int produtoEstoque,
                                                 @RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail) throws IOException {
        Produto updatedProduto = produtoService.updateProduto(id, produtoNome, produtoPreco, produtoEstoque, thumbnail);
        if (updatedProduto != null) {
            return ResponseEntity.ok(updatedProduto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para deletar um produto
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        boolean deleted = produtoService.deleteProduto(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
