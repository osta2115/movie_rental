package action_strategy;

import hibernate.ProductRepositoryHibernate;
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
    }

    public static StrategyCommons getInstance() {
        return INSTANCE;
    }

    private Client loggedUser;
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ProductRepositoryHibernate productRepositoryHibernate;


    Client setLoggedClient(Client client) {
        this.loggedUser = client;
        return client;
    }

    Client getClient() {
        if (loggedUser == null) {
            System.out.println("no user logged to system");
            return null;
        }
        else  return loggedUser;
    }

    boolean logoutUser () {
        loggedUser = null;
        return loggedUser == null;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
    public  ProductRepositoryHibernate getProductRepositoryHibernate(){
        return productRepositoryHibernate;
    }

    public boolean doWeContinue (){

        return false;
    }
}