package action_strategy;

import hibernate.ClientsRepositoryHibernate;
import hibernate.ProductRepositoryHibernate;
import hibernate.RentsRepository;
import hibernate.RentsRepositoryHibernate;
import tables.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Universal methods used in many panels.
 */
public class StrategyCommons {
    private static final StrategyCommons INSTANCE = new StrategyCommons();

    private StrategyCommons() {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental-dev");
        entityManager = entityManagerFactory.createEntityManager();
        productRepositoryHibernate = new ProductRepositoryHibernate(entityManager);
        clientsRepositoryHibernate = new ClientsRepositoryHibernate(entityManager);
        rentsRepositoryHibernate = new RentsRepositoryHibernate(entityManager);
    }

    public static StrategyCommons getInstance() {
        return INSTANCE;
    }

    private static Client loggedUser;
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ProductRepositoryHibernate productRepositoryHibernate;
    private static ClientsRepositoryHibernate clientsRepositoryHibernate;
    private static RentsRepositoryHibernate rentsRepositoryHibernate;


    public static Client setLoggedClient(Client client) {
        loggedUser = client;
        return client;
    }

    Client getClient() {
        if (loggedUser == null) {
            System.out.println("no user logged to system");
            return null;
        } else return loggedUser;
    }

    boolean logoutUser() {
        loggedUser = null;
        return loggedUser == null;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public static ProductRepositoryHibernate getProductRepositoryHibernate() {
        return productRepositoryHibernate;
    }

    public static ClientsRepositoryHibernate getClientsRepositoryHibernate() {
        return clientsRepositoryHibernate;
    }

    public static RentsRepositoryHibernate getRentsRepositoryHibernate() {
        return rentsRepositoryHibernate;
    }

    public boolean doWeContinue() {

        return false;
    }
}