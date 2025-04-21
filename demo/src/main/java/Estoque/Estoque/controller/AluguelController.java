package Estoque.Estoque.controller;

import Estoque.Estoque.dto.AluguelDTO;
import Estoque.Estoque.dto.ClienteFuncionarioDTO;
import Estoque.Estoque.model.Aluguel;
import Estoque.Estoque.model.FormaPagamento;
import Estoque.Estoque.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    @Autowired
    private AluguelService aluguelService;

    @PostMapping("/simples")
    public Aluguel iniciarAluguelSimples(@RequestBody ClienteFuncionarioDTO dto) {
        return aluguelService.registrarAluguel(dto.getCliente(), dto.getFuncionario(), List.of(), FormaPagamento.DINHEIRO);
    }

    @PostMapping("/com-produtos")
    public Aluguel iniciarAluguelComProdutos(@RequestBody AluguelDTO dto) {
        return aluguelService.registrarAluguel(dto.getCliente(), dto.getFuncionario(), dto.getItensAlugados(), dto.getFormaPagamento());
    }

    @GetMapping
    public List<Aluguel> listarAlugueis() {
        return aluguelService.listarTodos();
    }
    @DeleteMapping("/{id}")
    public void deletarAluguel(@PathVariable Long id) {
        aluguelService.deletarAluguel(id);
    }

}
