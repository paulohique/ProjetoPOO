package Estoque.Estoque.dto;

import Estoque.Estoque.model.Cliente;
import Estoque.Estoque.model.FormaPagamento;
import Estoque.Estoque.model.Funcionario;
import Estoque.Estoque.model.ItemAluguel;

import java.util.List;

public class AluguelDTO {
    private Cliente cliente;
    private Funcionario funcionario;
    private List<ItemAluguel> itensAlugados;
    private FormaPagamento formaPagamento;

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

    public List<ItemAluguel> getItensAlugados() {
        return itensAlugados;
    }

    public void setItensAlugados(List<ItemAluguel> itensAlugados) {
        this.itensAlugados = itensAlugados;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
// Getters e Setters
}
