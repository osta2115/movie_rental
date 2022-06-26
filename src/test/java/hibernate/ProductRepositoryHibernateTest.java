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
        Branch branch = Branch.builder().name("Gdańsk").postalCode("80-520").build();
        Carrier carrier = Carrier.builder().description("Kaseta").build();
        Category category = Category.builder().title("Horror").build();
        PegiCategory pegiCategory = PegiCategory.builder().title("18+").build();
        Director director = Director.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .build();

        return Product.builder()
                .branch(branch)
                .carrier(carrier)
                .category(category)
                .director(director)
                .pegiCategory(pegiCategory)
                .title("Taki se film")
                .build();
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
        try {
            productRepositoryHibernate.createProduct(prodct1);
        } catch (java.sql.SQLException throwables) {
            throwables.printStackTrace();
        }
        //then
//        assertThat(result).isEqualTo(true);
        assertThat(productRepositoryHibernate.getAllProducts().size()).isEqualTo(1);
    }

}