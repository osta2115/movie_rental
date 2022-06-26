package movie_rental;

import hibernate.ProductRepositoryHibernate;
import tables.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class MovieRentalMain {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ProductRepositoryHibernate productRepositoryHibernate;


    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental");
        entityManager = entityManagerFactory.createEntityManager();
        productRepositoryHibernate = new ProductRepositoryHibernate(entityManager);


        entityManager.close();
        entityManagerFactory.close();
    }
}
