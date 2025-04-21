package Estoque.Estoque.service;

import Estoque.Estoque.model.Cliente;
import Estoque.Estoque.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        // Verificar se o CPF já existe no banco
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new IllegalArgumentException("Já existe um cliente com o CPF informado.");
        }

        // Lógica para salvar o cliente
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        if (clienteRepository.existsById(id)) {
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null; // Pode lançar uma exceção personalizada aqui
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
