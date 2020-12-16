package DAO;

import connection.ConnectionFactory;
import main.java.model.Cliente;
import main.java.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProdutoDao implements DAO<Produto>{

    private EntityManager entityManager = new ConnectionFactory().getConnection();


    @Override
    public Produto save(Produto produto) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(produto);
            this.entityManager.getTransaction().commit();
        }catch (Exception error){
            this.entityManager.getTransaction().rollback();

        }finally {
            this.entityManager.close();
        }

        return null;
    }

    @Override
    public List<Produto> getList() {
        Query query = this.entityManager.createQuery("select c from Produto as prod");
        return query.getResultList();
    }

    @Override
    public Produto update(Produto object) {
        return null;
    }

    @Override
    public Produto delete(Long id) {
        return null;
    }

    @Override
    public Produto findById(Long id) {
        Produto produto = null;
        try{
            produto = entityManager.find(Produto.class, id);
        }catch (Exception e){
            System.out.println("Erro ao buscar por ID" + e);
        }

        return produto;
    }
}
