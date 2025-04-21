package Estoque.Estoque.controller;

import Estoque.Estoque.model.Produto;
import Estoque.Estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    // Criar novo produto
    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    // Listar todos os produtos
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }
}
