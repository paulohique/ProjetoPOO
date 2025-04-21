package Estoque.Estoque.service;

import Estoque.Estoque.model.Funcionario;
import Estoque.Estoque.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionarioAtualizado) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioAtualizado.setId(id);
            return funcionarioRepository.save(funcionarioAtualizado);
        }
        return null; // Pode lançar uma exceção personalizada aqui
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
