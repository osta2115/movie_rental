package movie_rental_dev;

import hibernate.ClientBasicInfo;
import hibernate.ClientsRepositoryHibernate;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Optional;

@Slf4j
public class MovieRentalDevMain {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ClientsRepositoryHibernate clientsRepositoryHibernate;


    public static void main(String[] args) throws SQLException {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental-dev");
        entityManager = entityManagerFactory.createEntityManager();
        clientsRepositoryHibernate = new ClientsRepositoryHibernate(entityManager);

        testAuthorization();

        entityManager.close();
        entityManagerFactory.close();

    }

    private static void testAuthorization() throws SQLException {
        clientsRepositoryHibernate.authorization("ankaskakanka", "mocneshaslo123");
    }

    private static void testGiveAdminPermission() throws SQLException {
        clientsRepositoryHibernate.giveAdmin(0);
    }

    private static void testGetClientBasicInfo() throws SQLException {
        var clientBasicInfoById = clientsRepositoryHibernate.getClientBasicInfoById(0);
        clientBasicInfoById.ifPresent(clientBasicInfo -> log.info("Found: {}", clientBasicInfo));
    }

    private static void testChangeClientFirstNameById() throws SQLException {
        clientsRepositoryHibernate.changeClientFirstName(0, "Bogdan");
    }

    private static void testDeleteClientById() throws SQLException {
        clientsRepositoryHibernate.deleteClientById(1);
    }

    private static void testCreateNewClient() throws SQLException {
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
        client.setAdmin(1);
        clientsRepositoryHibernate.createClient(client);
    }
}