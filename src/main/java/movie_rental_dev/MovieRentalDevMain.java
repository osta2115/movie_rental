package movie_rental_dev;

import hibernate.ClientsRepositoryHibernate;
import hibernate.RentsRepositoryHibernate;
import lombok.extern.slf4j.Slf4j;
import tables.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.time.LocalDate;

@Slf4j
public class MovieRentalDevMain {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ClientsRepositoryHibernate clientsRepositoryHibernate;
    private static RentsRepositoryHibernate rentsRepositoryHibernate;


    public static void main(String[] args) throws SQLException {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental-dev");
        entityManager = entityManagerFactory.createEntityManager();
        clientsRepositoryHibernate = new ClientsRepositoryHibernate(entityManager);
        rentsRepositoryHibernate = new RentsRepositoryHibernate(entityManager);

        //testCreateRent();
        //testIsProductAvailableAtGivenDate();
        testFirstAvailableDate();

        entityManager.close();
        entityManagerFactory.close();

    }

    private static void testFirstAvailableDate() throws SQLException {
        rentsRepositoryHibernate.firstAvailableDate(29);
    }

    private static void testIsProductAvailableAtGivenDate() throws SQLException {
        rentsRepositoryHibernate.isProductAvailableAtGivenDate(23, LocalDate.of(2022, 06, 12));
    }

    private static void testIsProductAvailableNow() throws SQLException {
        rentsRepositoryHibernate.isProductAvailableNow(29);
    }

    private static void testCreateRent() throws SQLException {
        Client client = new Client();
        client.setId(1);
        client.setFirstName("Jan");
        client.setLastName("Kowalski");
        client.setPhoneNumber("669420511");
        client.setEmail("jan.kowalski@gmail.com");
        client.setPostalCode("20-420");
        client.setAddress("Krakowskie Przedmieście 5/24");
        client.setLogin("jankow56");
        client.setPassword("1234");
        client.setAdmin(1);

        Product product = MovieRentalTestR.buildProductWithName("Jakiś film");

        Rent rent = new Rent();
        //rent.setId(0);
        rent.setClient(client);
        rent.setProduct(product);
        rent.setRentDate(LocalDate.of(2022,5,23));
        rent.setReturnDate(LocalDate.of(2022,7,11));

        rentsRepositoryHibernate.createRent(rent);
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
        client.setFirstName("Jan");
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