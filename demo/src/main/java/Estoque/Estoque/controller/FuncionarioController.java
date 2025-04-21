package Estoque.Estoque.controller;

import Estoque.Estoque.model.Funcionario;
import Estoque.Estoque.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    // Criar novo funcionário
    @PostMapping
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.cadastrarFuncionario(funcionario);
    }

    // Listar todos os funcionários
    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    // Buscar funcionário por ID
    @GetMapping("/{id}")
    public Optional<Funcionario> buscarFuncionarioPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id);
    }

    // Atualizar funcionário por ID
    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return funcionarioService.atualizarFuncionario(id, funcionario);
    }

    // Deletar funcionário por ID
    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
    }
}
