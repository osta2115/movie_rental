package movie_rental_dev;

import hibernate.ClientsRepositoryHibernate;
import tables.Client;
import tables.Product;
import tables.Rent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MovieRentalDevMain {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ClientsRepositoryHibernate clientsRepositoryHibernate;


    public static void main(String[] args) throws SQLException {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental-dev");
        entityManager = entityManagerFactory.createEntityManager();
        clientsRepositoryHibernate = new ClientsRepositoryHibernate(entityManager);

        testChangingClientFirstNameById();

        entityManager.close();
        entityManagerFactory.close();

    }

    private static void testChangingClientFirstNameById() throws SQLException {
        clientsRepositoryHibernate.changeClientFirstName(0, "Bogdan");
    }

    private static void testDeletingClientById() throws SQLException {
        clientsRepositoryHibernate.deleteClientById(1);
    }

    private static void testCreatingNewClient() throws SQLException {
        Client client = new Client();
        client.setId(1);
        client.setFirstName("Jank");
        client.setLastName("Kowalski");
        client.setPhoneNumber("669420511");
        client.setEmail("jan.kowalski@gmail.com");
        client.setPostalCode("20-420");
        client.setAddress("Krakowskie Przedmieście 5/24");
        client.setLogin("jankow56");
        client.setPassword("1234");
        clientsRepositoryHibernate.createClient(client);
    }
}