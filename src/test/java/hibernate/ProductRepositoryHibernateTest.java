package hibernate;

import org.junit.jupiter.api.*;
import tables.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductRepositoryHibernateTest {
    static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;
    static ProductRepositoryHibernate productRepositoryHibernate;


    static Product buildProduct() {
        Branch branch = new Branch();
        branch.setName("Gdańsk");
        branch.setPostalCode("80-520");

        Carrier carrier = new Carrier();
        carrier.setDescription("Kaseta");

        Category category = new Category();
        category.setTitle("Horror");

        PegiCategory pegiCategory = new PegiCategory();
        pegiCategory.setTitle("18+");

        Director director = new Director();
        director.setFirstName("Jan");
        director.setLastName("Kowalski");

        Product product = new Product();
        product.setBranch(branch);
        product.setCarrier(carrier);
        product.setCategory(category);
        product.setDirector(director);
        product.setPegiCategory(pegiCategory);
        product.setTitle("Taki se film");

        return product;
    }

    @BeforeEach
    void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental-dev");
        entityManager = entityManagerFactory.createEntityManager();
        productRepositoryHibernate = new ProductRepositoryHibernate(entityManager);
    }

    @AfterEach
    void cleanup() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void productAddedToTable() {
        //given
        var prodct1 = buildProduct();
        //when
        productRepositoryHibernate.createProduct(prodct1);

        //then
//        assertThat(result).isEqualTo(true);
        assertThat(productRepositoryHibernate.getAllProducts().size()).isEqualTo(1);
    }

}