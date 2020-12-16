package main.java.model;

import javax.persistence.*;

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

    public void setId(long id) {
        this.id = id;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
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