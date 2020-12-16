package DAO;

import connection.ConnectionFactory;
import main.java.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClienteDao implements DAO<Cliente> {

    private EntityManager entityManager = new ConnectionFactory().getConnection();

    @Override
    public Cliente save(Cliente cliente) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(cliente);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();

        } finally {
            this.entityManager.close();
        }
        return null;
    }

    @Override
    public List<Cliente> getList() {
        Query query = this.entityManager.createQuery("select c from Cliente as c");
        return query.getResultList();
    }

    @Override
    public Cliente update(Cliente cliente) {
        Cliente clienteUp = null;
        try {
            this.entityManager.getTransaction().begin();
            if (cliente.getId() == null) {
                this.entityManager.persist(cliente);
            } else {
                clienteUp = this.entityManager.merge(cliente);
                this.entityManager.getTransaction().commit();
            }
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return clienteUp;
    }

    @Override
    public Cliente delete(Long id) {
        Cliente cliente = null;
        try {
            cliente = entityManager.find(Cliente.class, id);
            if(cliente.getPedidos() == null){
                this.entityManager.getTransaction().begin();
                this.entityManager.remove(cliente);
                this.entityManager.getTransaction().commit();
            } else {
                // TODO: Throw exception here!!
                System.out.println("Nao eh possivel apagar um cliente vinculado a um pedido");
            }

        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return cliente;
    }

    @Override
    public Cliente findById(Long id) {
        Cliente cliente = null;
        try {
            cliente = entityManager.find(Cliente.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao buscar por ID" + e);
        }

        return cliente;
    }
}
