package movie_rental;

import hibernate.ProductRepositoryHibernate;
import tables.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class MovieRentalTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ProductRepositoryHibernate productRepositoryHibernate;


    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental-dev");
        entityManager = entityManagerFactory.createEntityManager();
        var product1 = buildProductWithName("Taki se film 2");
        var product2 = buildProductWithName("Testowy film 3");
        productRepositoryHibernate = new ProductRepositoryHibernate(entityManager);
        try {
            productRepositoryHibernate.createProduct(product1);
//            productRepositoryHibernate.createProduct(product2);
        } catch (java.sql.SQLException throwables) {
            throwables.printStackTrace();
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    static Product buildProductWithName(String name) {
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
                .title(name)
                .releaseDate(LocalDate.of(1930, 3, 27))
                .build();
    }
}

