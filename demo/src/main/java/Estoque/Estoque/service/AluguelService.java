package Estoque.Estoque.service;

import Estoque.Estoque.model.*;
import Estoque.Estoque.repository.AluguelRepository;
import Estoque.Estoque.repository.ClienteRepository;
import Estoque.Estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository; // Adicionando o repositório de cliente

    @Transactional
    public Aluguel registrarAluguel(Cliente cliente, Funcionario funcionario, List<ItemAluguel> itens, FormaPagamento formaPagamento) {
        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(cliente);
        aluguel.setFuncionario(funcionario);
        aluguel.setItensAlugados(itens);
        aluguel.setFormaPagamento(formaPagamento);

        // Garantir que os produtos associados ao ItemAluguel estão corretamente carregados
        for (ItemAluguel item : itens) {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado!"));
            item.setProduto(produto);  // Atualiza o produto no ItemAluguel

            produto.reduzirEstoque(item.getQuantidade()); // Atualiza o estoque do produto
            produtoRepository.save(produto);  // Salva o produto com o estoque atualizado
        }

        aluguel.calcularValorTotal(); // Calcula o valor total do aluguel

        // Incrementar o número de pedidos do cliente
//        cliente.incrementarPedidos(1);
       // clienteRepository.save(cliente); // Salva o cliente com o número de pedidos atualizado

        return aluguelRepository.save(aluguel); // Salva o aluguel no banco de dados
    }

    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }

    @Transactional
    public void deletarAluguel(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluguel não encontrado com ID: " + id));

        // Restaurar o estoque dos produtos alugados
        for (ItemAluguel item : aluguel.getItensAlugados()) {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado!"));

            produto.setEstoque(produto.getEstoque() + item.getQuantidade());
            produtoRepository.save(produto);
        }

        aluguelRepository.delete(aluguel);
    }
}
