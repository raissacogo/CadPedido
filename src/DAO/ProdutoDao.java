package DAO;

import connection.ConnectionFactory;
import main.java.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProdutoDao implements DAO<Produto> {

    private EntityManager entityManager = new ConnectionFactory().getConnection();


    @Override
    public Produto save(Produto produto) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(produto);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();

        } finally {
            this.entityManager.close();
        }

        return produto;
    }

    @Override
    public List<Produto> getList() {
        Query query = this.entityManager.createQuery("select prod from Produto as prod");
        return query.getResultList();
    }

    @Override
    public Produto update(Produto produto) {

        Produto produtoUp = null;
        try {
            this.entityManager.getTransaction().begin();
            if (produto.getId() == null) {
                this.entityManager.persist(produto);
            } else {
                produtoUp = this.entityManager.merge(produto);
                this.entityManager.getTransaction().commit();
            }
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return produtoUp;
    }

    @Override
    public Produto delete(Long id) {

        Produto produto = null;
        try {
            produto = entityManager.find(Produto.class, id);

            this.entityManager.getTransaction().begin();
            this.entityManager.remove(produto);
            this.entityManager.getTransaction().commit();

        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return produto;
    }

    @Override
    public Produto findById(Long id) {
        Produto produto = null;
        try {
            produto = entityManager.find(Produto.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao buscar por ID" + e);
        }

        return produto;
    }
}
