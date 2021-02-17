package main.java.control;

import DAO.ClienteDao;
import DAO.PedidoDao;
import DAO.ProdutoDao;
import main.java.model.Cliente;
import main.java.model.FormaDePagamento;
import main.java.model.Pedido;
import main.java.model.Produto;

import java.util.Arrays;
import java.util.List;

public class PedidoController {

    public void savePedido(Cliente cliente, List<Produto> produtoList, FormaDePagamento formaDePagamento, int quantidade, float valorUnitario, float valorTotal) {

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProdutoList(produtoList);
        pedido.setFormaDePagamento(formaDePagamento);
        pedido.setQuantidade(quantidade);
        pedido.setValorUnitario(valorUnitario);
        pedido.setValorTotal();

        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.save(pedido);

        cliente.setPedidos(Arrays.asList(pedido));
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.update(cliente);

        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto p : produtoList){
            p.setPedido(pedido);
            produtoDao.update(p);
        }




    }

    public void updatePedido(Produto produto, String tipoProduto, String sabor, int quantidade, float valorCusto, float valorUnitario) {

        produto.setQuantidade(quantidade);
        produto.setSabor(sabor);
        produto.setTipoProduto(tipoProduto);
        produto.setValorCusto(valorCusto);
        produto.setValorUnitario(valorUnitario);

        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.update(produto);
    }
}
