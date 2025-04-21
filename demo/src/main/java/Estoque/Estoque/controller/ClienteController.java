package Estoque.Estoque.controller;

import Estoque.Estoque.model.Cliente;
import Estoque.Estoque.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // Criar novo cliente
    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        // Verificar se o CPF é null ou "0"
        if (cliente.getCpf() == null || cliente.getCpf().equals("0")) {
            throw new IllegalArgumentException("O CPF não pode ser nulo ou igual a 0.");
        }

        return clienteService.cadastrarCliente(cliente);
    }


    // Listar todos os clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public Optional<Cliente> buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    // Atualizar cliente por ID
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    // Deletar cliente por ID
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }
}
