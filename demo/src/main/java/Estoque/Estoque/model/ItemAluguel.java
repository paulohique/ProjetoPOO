package Estoque.Estoque.model;

import jakarta.persistence.*;

@Entity
public class ItemAluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private int quantidade;

    private double precoUnitario;

    public ItemAluguel() {
    }

    public ItemAluguel(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        atualizarPrecoUnitario(); // Atualiza o preço ao instanciar o item
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        atualizarPrecoUnitario(); // Atualiza o preço unitário ao associar o produto
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getTotal() {
        return this.quantidade * this.precoUnitario;
    }

    // Método para atualizar o preço unitário com base no preço atual do produto
    public void atualizarPrecoUnitario() {
        if (this.produto != null) {
            this.precoUnitario = this.produto.getPreco();
        }
    }
}
