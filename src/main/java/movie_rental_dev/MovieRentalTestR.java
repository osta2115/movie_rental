package movie_rental_dev;

import hibernate.ProductRepositoryHibernate;
import tables.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class MovieRentalTestR {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ProductRepositoryHibernate productRepositoryHibernate;


    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-movie-rental-dev");
        entityManager = entityManagerFactory.createEntityManager();
        productRepositoryHibernate = new ProductRepositoryHibernate(entityManager);

        addProductTest();
//        addProductTest();
//        productRepositoryHibernate.getProductById(1).ifPresent(System.out::println);
//        branchTest();
//        directorTest();
//        categoryTest();
//        pegiCategoriesTest();
//        carrierTest();

//        productRepositoryHibernate.deleteProductById(5);
//        productRepositoryHibernate.deleteProductById(43);
        List<Product> allProducts = productRepositoryHibernate.getAllProducts();
        allProducts.forEach(System.out::println);

    }

    private static void carrierTest() {
        Carrier carrier1 = Carrier.builder().description("płyta").build();
        Carrier carrier2 = Carrier.builder().description("taśma").build();
        Carrier carrier3 = Carrier.builder().description("kaseta").build();

        System.out.println(productRepositoryHibernate.getCarrier(carrier1).isPresent());
        System.out.println(productRepositoryHibernate.getCarrier(carrier2).isPresent());
        System.out.println(productRepositoryHibernate.getCarrier(carrier3).isPresent());

        productRepositoryHibernate.addCarrier(carrier1);
        productRepositoryHibernate.addCarrier(carrier2);
        productRepositoryHibernate.addCarrier(carrier3);


        System.out.println(productRepositoryHibernate.getCarrier(carrier1).isPresent());
        System.out.println(productRepositoryHibernate.getCarrier(carrier2).isPresent());
        System.out.println(productRepositoryHibernate.getCarrier(carrier3).isPresent());

        productRepositoryHibernate.removeCarrier(carrier2);

        System.out.println(productRepositoryHibernate.getCarrier(carrier1).isPresent());
        System.out.println(productRepositoryHibernate.getCarrier(carrier2).isPresent());
        System.out.println(productRepositoryHibernate.getCarrier(carrier3).isPresent());
    }

    private static void pegiCategoriesTest() {
        PegiCategory pegi14 = PegiCategory.builder().title("14").build();
        PegiCategory pegi18 = PegiCategory.builder().title("18").build();
        PegiCategory pegi4 = PegiCategory.builder().title("4").build();

        System.out.println("--------------------------");
        productRepositoryHibernate.getPegiCategory(pegi4);
        productRepositoryHibernate.getPegiCategory(pegi14);
        productRepositoryHibernate.getPegiCategory(pegi18);
        System.out.println("--------------------------");
        productRepositoryHibernate.addPegiCategory(pegi4);
        productRepositoryHibernate.addPegiCategory(pegi14);
        productRepositoryHibernate.addPegiCategory(pegi18);
        System.out.println("--------------------------");
        productRepositoryHibernate.getPegiCategory(pegi4);
        productRepositoryHibernate.getPegiCategory(pegi14);
        productRepositoryHibernate.getPegiCategory(pegi18);
        System.out.println("--------------------------");
        productRepositoryHibernate.removePegiCategory(pegi4);
        System.out.println("--------------------------");
        productRepositoryHibernate.getPegiCategory(pegi4);
        productRepositoryHibernate.getPegiCategory(pegi14);
        productRepositoryHibernate.getPegiCategory(pegi18);
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void categoryTest() {
        Category category1 = Category.builder().title("Dramat").build();
        Category category2 = Category.builder().title("Komedia").build();
        productRepositoryHibernate.addCategory(category1);
        productRepositoryHibernate.addCategory(category1);
        productRepositoryHibernate.addCategory(category2);
        productRepositoryHibernate.getCategory(category1);
        productRepositoryHibernate.getCategory(category2);
        productRepositoryHibernate.removeCategory(category2);
        productRepositoryHibernate.getCategory(category2);
    }

    private static void directorTest() {
        Director director1 = Director.builder().firstName("Janina").lastName("Jakaś").build();
        Director director2 = Director.builder().firstName("Jan").lastName("Jakiś").build();
        productRepositoryHibernate.addDirector(director1);
        productRepositoryHibernate.addDirector(director2);
        productRepositoryHibernate.getDirector(director1);
        productRepositoryHibernate.getDirector(director2);
        productRepositoryHibernate.removeDirector(director2);
        productRepositoryHibernate.getDirector(director1);
        productRepositoryHibernate.getDirector(director2);
    }

    private static void branchTest() {
        Branch branch1 = Branch.builder().name("Gdzies").postalCode("90-190").adres("ulica1").build();
        Branch branch2 = Branch.builder().name("Gdzies 2").postalCode("90-190").adres("ulica3").build();

        productRepositoryHibernate.addBranch(branch1);
        productRepositoryHibernate.addBranch(branch2);
        System.out.println(productRepositoryHibernate.getBranch(branch1));
        productRepositoryHibernate.removeBranch(branch1);
        productRepositoryHibernate.removeBranch(branch1);
    }

    private static void addProductTest() {
        var product1 = buildProductWithName("Poczwara");
//        var product2 = buildProductWithName("Taki se film 3");
//        var product3 = buildProductWithName("Taki se film: powrót");
        productRepositoryHibernate.createProduct(product1);
//            productRepositoryHibernate.createProduct(product2);
//            productRepositoryHibernate.createProduct(product3);

    }

    static Product buildProductWithName(String name) {
        Branch branch = Branch.builder().name("Morskie Oko").postalCode("80-231").build();
        Carrier carrier = Carrier.builder().description("kaseta").build();
        Category category = Category.builder().title("Karykatura").build();
        PegiCategory pegiCategory = PegiCategory.builder().title("0").build();
        Director director = Director.builder()
                .firstName("Najlepszy")
                .lastName("Reżyser")
                .build();

        return Product.builder()
                .branch(branch)
                .carrier(carrier)
                .category(category)
                .director(director)
                .pegiCategory(pegiCategory)
                .title(name)
                .releaseDate(LocalDate.of(1960, 6, 11))
                .build();
    }
}

