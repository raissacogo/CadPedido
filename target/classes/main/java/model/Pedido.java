package main.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToOne (cascade = CascadeType.REMOVE, mappedBy = "pedido")
    private Cliente cliente;/*chama a classe cliente */
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<Produto> produtoList; /* Cria uma lista de produto, possibilitando que  + de 1 seja cadastrado*/
    private FormaDePagamento formaDePagamento; /*chama a classe forma de pagamento */
    private int quantidade;
    private float valorUnitario;
    private float valorTotal;

    //não é possivel cadastrar um pedido sem o cliente e sem o produto.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal() {
        this.valorTotal = quantidade * valorUnitario;
        //verificar o valor Total, por serem mais produtos cadastrados.
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", produtoList=" + produtoList +
                ", formaDePagamento=" + formaDePagamento +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
