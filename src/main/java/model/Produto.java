package main.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tipoProduto;
    private String sabor;
    private int quantidade;
    private float valorCusto;
    private float valorUnitario;

    @OneToMany
    private List<Pedido> produtoList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public List<Pedido> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Pedido> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", tipoProduto='" + tipoProduto + '\'' +
                ", sabor='" + sabor + '\'' +
                ", quantidade=" + quantidade +
                ", valorCusto=" + valorCusto +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}