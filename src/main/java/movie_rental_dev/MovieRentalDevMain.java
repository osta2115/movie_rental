package movie_rental_dev;

import hibernate.ClientBasicInfo;
import hibernate.ClientsRepositoryHibernate;
import hibernate.ProductRepositoryHibernate;
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
    private static ProductRepositoryHibernate productRepositoryHibernate;


    public static void main(String[] args) throws SQLException {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental-dev");
        entityManager = entityManagerFactory.createEntityManager();
        clientsRepositoryHibernate = new ClientsRepositoryHibernate(entityManager);
        productRepositoryHibernate = new ProductRepositoryHibernate(entityManager);
        rentsRepositoryHibernate = new RentsRepositoryHibernate(entityManager);

//        testCreateNewClient();
//        testCreateNewClient();
//        testCreateNewClient();
        testCreateRent();
        testIsProductAvailableAtGivenDate();
//        testFirstAvailableDate();

        System.out.println("test");
        entityManager.close();
        entityManagerFactory.close();

    }

    private static void testFirstAvailableDate() throws SQLException {
        rentsRepositoryHibernate.firstAvailableDate(29);
    }

    private static void testIsProductAvailableAtGivenDate() throws SQLException {
        rentsRepositoryHibernate.isProductAvailableAtGivenDate(10, LocalDate.of(2022, 10, 12));
    }

    private static void testIsProductAvailableNow() throws SQLException {
        rentsRepositoryHibernate.isProductAvailableNow(29);
    }

    private static void testCreateRent() throws SQLException {

        Client client = clientsRepositoryHibernate.getClientById(1).get();
//        Client client = new Client();
//        client.setFirstName(clientBasicInfo.getFirstName());
//        client.setLastName(clientBasicInfo.getLastName());
//        client.setPhoneNumber("669420511");
//        client.setEmail("jan.kowalski@gmail.com");
//        client.setPostalCode("20-420");
//        client.setAddress("Krakowskie Przedmieście 5/24");
//        client.setLogin(clientBasicInfo.getLogin());
//        client.setLogin(clientBasicInfo.getLogin());
//        client.setPassword("1234");
//        client.setAdmin(1);

        Product product = buildProductWithName("Straszny film");

        Rent rent = new Rent();
        //rent.setId(0);
        rent.setClient(client);
        rent.setProduct(product);
        rent.setRentDate(LocalDate.of(2022, 5, 23));
        rent.setReturnDate(LocalDate.of(2022, 7, 11));

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

    private static void testCreateNewClient() {
        Client client = new Client();
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

    static Product buildProductWithName(String name) {
        Branch branchTmp = new Branch();
        branchTmp.setName("Gdzies");
        branchTmp.setAdres("ulica");
        branchTmp.setPostalCode("12-345");
        Branch branch = productRepositoryHibernate.addBranch(branchTmp);

        Carrier tmpCarrier = new Carrier();
        tmpCarrier.setDescription("taśma");
        Carrier carrier = productRepositoryHibernate.addCarrier(tmpCarrier);

        Category tmpCategory = new Category();
        tmpCategory.setTitle("DRAMAT");
        Category category = productRepositoryHibernate.addCategory(tmpCategory);


        PegiCategory tmpPegi = new PegiCategory();
        tmpPegi.setTitle("+18");
        PegiCategory pegiCategory = productRepositoryHibernate.addPegiCategory(tmpPegi);

        Director tmpDir = new Director();
        tmpDir.setFirstName("Jan");
        tmpDir.setLastName("Janowski");
        Director director = productRepositoryHibernate.addDirector(tmpDir);


        Product product = new Product();
        product.setPegiCategory(pegiCategory);
        product.setCategory(category);
        product.setDirector(director);
        product.setCarrier(carrier);
        product.setBranch(branch);
        product.setTitle(name);
        product.setReleaseDate(LocalDate.of(1996, 12, 13));
        return product;
    }
}