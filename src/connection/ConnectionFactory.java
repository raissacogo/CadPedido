package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory
            ("CadPedido");

    public EntityManager getConnection() {
        return factory.createEntityManager();
    }
}



