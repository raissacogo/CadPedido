package main.java.model;

import DAO.ClienteDao;
import DAO.PedidoDao;
import DAO.ProdutoDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

       // saveClienteWithPedido();

        //saveProduto();

        ligarProdutoaPedido();

    }

    public static void saveClienteWithPedido(){
        Pedido pedido = new Pedido();
        pedido.setQuantidade(100);
        pedido.setValorUnitario(5);
        pedido.setFormaDePagamento(FormaDePagamento.DINHEIRO);

        Cliente cliente = new Cliente();
        cliente.setNome("José");
        cliente.setEndereco("Rua B");
        cliente.setTelefone("88997766");

        pedido.setCliente(cliente);

        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList.add(pedido);

        cliente.setPedidos(pedidoList);

        ClienteDao clienteDao = new ClienteDao();
        clienteDao.save(cliente);
    }

    public static void updateClienteWithPedido(){
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.findById(5l);

        Pedido pedido = new Pedido();
        pedido.setQuantidade(50);
        pedido.setValorUnitario(5);
        pedido.setFormaDePagamento(FormaDePagamento.CREDITO);
        pedido.setCliente(cliente);

        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList.add(pedido);

        cliente.setPedidos(pedidoList);

        clienteDao.update(cliente);
    }

    public static void saveProduto(){
        Produto produto = new Produto();
        produto.setQuantidade(3);
        produto.setSabor("Brigadeiro");
        produto.setTipoProduto("Doces");
        produto.setValorCusto(2.00f);
        produto.setValorUnitario(2.50f);

        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.save(produto);

    }

    public static void ligarProdutoaPedido(){

        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.findById(4l);

        PedidoDao pedidoDao = new PedidoDao();
        Pedido pedido = pedidoDao.findById(3l);

        produto.setPedido(pedido);
        pedido.setProdutoList(Arrays.asList (produto));

        pedidoDao.update(pedido);
        produtoDao.update(produto);


    }
}
