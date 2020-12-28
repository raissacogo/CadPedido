package DAO;

import connection.ConnectionFactory;
import main.java.model.Cliente;
import main.java.model.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PedidoDao implements DAO<Pedido> {

    private EntityManager entityManager = new ConnectionFactory().getConnection();

    @Override
    public Pedido save(Pedido pedido) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(pedido);
            this.entityManager.getTransaction().commit();
        }catch (Exception error){
            this.entityManager.getTransaction().rollback();

        }finally {
            this.entityManager.close();
        }
        return pedido;
    }

    @Override
    public List <Pedido>getList() {
        Query query = this.entityManager.createQuery("select p from Pedido as p");
        return query.getResultList();

    }

    @Override
    public Pedido update(Pedido pedido) {
        return null;
    }

    @Override
    public Pedido delete(Long id) {
        return null;
    }

    @Override
    public Pedido findById(Long id) {
        Pedido pedido = null;
        try{
            pedido = entityManager.find(Pedido.class, id);
        }catch (Exception e){
            System.out.println("Erro ao buscar por ID" + e);
        }

        return pedido;
    }
}
