package Estoque.Estoque.service;

import Estoque.Estoque.exeption.EstoqueInsuficienteException;
import Estoque.Estoque.exeption.RecursoNaoEncontradoException;
import Estoque.Estoque.model.Produto;
import Estoque.Estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Listar todos os produtos
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    // Buscar produto por ID
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com ID: " + id));
    }

    // Adicionar novo produto
    @Transactional
    public Produto adicionarProduto(Produto produto) {
        if (produtoRepository.existsByNome(produto.getNome())) {
            throw new IllegalArgumentException("Produto com esse nome já existe.");
        }
        return produtoRepository.save(produto);
    }

    // Atualizar um produto
    @Transactional
    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Produto produtoExistente = buscarProdutoPorId(id);
        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setPreco(produtoAtualizado.getPreco());
        produtoExistente.setEstoque(produtoAtualizado.getEstoque());

        return produtoRepository.save(produtoExistente);
    }

    // Deletar um produto
    @Transactional
    public void deletarProduto(Long id) {
        Produto produto = buscarProdutoPorId(id);
        produtoRepository.delete(produto);
    }

    // Reduzir estoque ao alugar/vender um produto
    @Transactional
    public void reduzirEstoque(Long id, int quantidade) {
        Produto produto = buscarProdutoPorId(id);
        if (produto.getEstoque() < quantidade) {
            throw new EstoqueInsuficienteException("Estoque insuficiente para o produto: " + produto.getNome());
        }
        produto.setEstoque(produto.getEstoque() - quantidade);
        produtoRepository.save(produto);
    }

    // Aumentar estoque (para devoluções ou ajustes)
    @Transactional
    public void aumentarEstoque(Long id, int quantidade) {
        Produto produto = buscarProdutoPorId(id);
        produto.setEstoque(produto.getEstoque() + quantidade);
        produtoRepository.save(produto);
    }
}
