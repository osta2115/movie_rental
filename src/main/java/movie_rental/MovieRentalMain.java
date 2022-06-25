package movie_rental;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovieRentalMain {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;


    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.close();
        entityManagerFactory.close();
    }

}
