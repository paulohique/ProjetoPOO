package Estoque.Estoque.dto;

import Estoque.Estoque.model.Cliente;
import Estoque.Estoque.model.Funcionario;

public class ClienteFuncionarioDTO {
    private Cliente cliente;
    private Funcionario funcionario;

    // Getters e Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
