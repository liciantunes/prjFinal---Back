package com.example.demo.services;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Método para criar um novo produto
    public Produto createProduto(String nome, String preco, int estoque, MultipartFile thumbnail) throws IOException {
        Produto produto = new Produto();
        produto.setProdutoNome(nome);
        produto.setProdutoPreco(preco);
        produto.setProdutoEstoque(estoque);
        produto.setThumbnail(thumbnail.getBytes());  // Armazena o conteúdo da imagem como byte[]

        return produtoRepository.save(produto);
    }

    

    public List<Produto> getAllProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        produtos.forEach(produto -> {
            // Verifica se a imagem (thumbnail) existe
            if (produto.getThumbnail() != null) {
                // Convertendo a imagem para base64
                String base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(produto.getThumbnail());
                produto.setProdutoImagem(base64Image); // Definindo a imagem em base64 no campo produtoImagem
            }
        });
        return produtos;
    }

   

    // Atualizar um produto
    public Produto updateProduto(Long id, String nome, String preco, int estoque, MultipartFile thumbnail) throws IOException {
        Produto produto = produtoRepository.findById(id).orElse(null);

        if (produto != null) {
            produto.setProdutoNome(nome);
            produto.setProdutoPreco(preco);
            produto.setProdutoEstoque(estoque);

            if (thumbnail != null) {
                produto.setThumbnail(thumbnail.getBytes());
            }

            return produtoRepository.save(produto);
        }
        return null;
    }

    // Deletar um produto
    public boolean deleteProduto(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null) {
            produtoRepository.delete(produto);
            return true;
        }
        return false;
    }
}
