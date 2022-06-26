package movie_rental_dev;

import hibernate.ProductRepositoryHibernate;
import tables.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class MovieRentalTestR {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ProductRepositoryHibernate productRepositoryHibernate;


    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental-dev");
        entityManager = entityManagerFactory.createEntityManager();
        productRepositoryHibernate = new ProductRepositoryHibernate(entityManager);

//        addProductTest();
//        productRepositoryHibernate.getProductById(1).ifPresent(System.out::println);
//        branchTest();
//        directorTest();
//        categoryTest();
//        pegiCategoriesTest();

    }

    private static void pegiCategoriesTest() {
        PegiCategory pegi14 = PegiCategory.builder().title("14").build();
        PegiCategory pegi18 = PegiCategory.builder().title("18").build();
        PegiCategory pegi4 = PegiCategory.builder().title("4").build();

        System.out.println("--------------------------");
        productRepositoryHibernate.findPegiCategory(pegi4);
        productRepositoryHibernate.findPegiCategory(pegi14);
        productRepositoryHibernate.findPegiCategory(pegi18);
        System.out.println("--------------------------");
        productRepositoryHibernate.addPegiCategory(pegi4);
        productRepositoryHibernate.addPegiCategory(pegi14);
        productRepositoryHibernate.addPegiCategory(pegi18);
        System.out.println("--------------------------");
        productRepositoryHibernate.findPegiCategory(pegi4);
        productRepositoryHibernate.findPegiCategory(pegi14);
        productRepositoryHibernate.findPegiCategory(pegi18);
        System.out.println("--------------------------");
        productRepositoryHibernate.removePegiCategory(pegi4);
        System.out.println("--------------------------");
        productRepositoryHibernate.findPegiCategory(pegi4);
        productRepositoryHibernate.findPegiCategory(pegi14);
        productRepositoryHibernate.findPegiCategory(pegi18);
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void categoryTest() {
        Category category1 = Category.builder().title("Dramat").build();
        Category category2 = Category.builder().title("Komedia").build();
        productRepositoryHibernate.addCategory(category1);
        productRepositoryHibernate.addCategory(category1);
        productRepositoryHibernate.addCategory(category2);
        productRepositoryHibernate.findCategory(category1);
        productRepositoryHibernate.findCategory(category2);
        productRepositoryHibernate.removeCategory(category2);
        productRepositoryHibernate.findCategory(category2);
    }

    private static void directorTest() {
        Director director1 = Director.builder().firstName("Janina").lastName("Jakaś").build();
        Director director2 = Director.builder().firstName("Jan").lastName("Jakiś").build();
        productRepositoryHibernate.addDirector(director1);
        productRepositoryHibernate.addDirector(director2);
        productRepositoryHibernate.findDirector(director1);
        productRepositoryHibernate.findDirector(director2);
        productRepositoryHibernate.removeDirector(director2);
        productRepositoryHibernate.findDirector(director1);
        productRepositoryHibernate.findDirector(director2);
    }

    private static void branchTest() {
        Branch branch1 = Branch.builder().name("Gdzies").postalCode("90-190").adres("ulica1").build();
        Branch branch2 = Branch.builder().name("Gdzies 2").postalCode("90-190").adres("ulica3").build();

        productRepositoryHibernate.addBranch(branch1);
        productRepositoryHibernate.addBranch(branch2);
        System.out.println(productRepositoryHibernate.findBranch(branch1));
        productRepositoryHibernate.removeBranch(branch1);
        productRepositoryHibernate.removeBranch(branch1);
    }

    private static void addProductTest() {
        var product1 = buildProductWithName("Taki se film 2");
        try {
            productRepositoryHibernate.createProduct(product1);
//            productRepositoryHibernate.createProduct(product2);
        } catch (java.sql.SQLException throwable) {
            throwable.printStackTrace();
        }
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

