package Estoque.Estoque.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAluguel;

    @ManyToOne(optional = true) // Cliente pode ser nulo
    private Cliente cliente;

    @ManyToOne(optional = false) // Funcionário é obrigatório
    private Funcionario funcionario;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemAluguel> itensAlugados; // Produtos e quantidades

    private double valorTotal;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    public Aluguel() {
        this.dataAluguel = LocalDate.now();
    }

    public void calcularValorTotal() {
        this.valorTotal = itensAlugados.stream()
                .mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade())
                .sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

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
        calcularValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }


}
