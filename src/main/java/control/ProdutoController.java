package main.java.control;

import DAO.ProdutoDao;
import main.java.model.Produto;

public class ProdutoController {

    public void saveOnlyProduto(String tipoProduto, String sabor, int quantidade, float valorCusto, float valorUnitario) {

        Produto produto = new Produto();
        produto.setQuantidade(quantidade);
        produto.setSabor(sabor);
        produto.setTipoProduto(tipoProduto);
        produto.setValorCusto(valorCusto);
        produto.setValorUnitario(valorUnitario);

        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.save(produto);

    }

    public void updateOnlyProduto(Produto produto, String tipoProduto, String sabor, int quantidade, float valorCusto, float valorUnitario){

        produto.setQuantidade(quantidade);
        produto.setSabor(sabor);
        produto.setTipoProduto(tipoProduto);
        produto.setValorCusto(valorCusto);
        produto.setValorUnitario(valorUnitario);

        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.update(produto);
    }

}
