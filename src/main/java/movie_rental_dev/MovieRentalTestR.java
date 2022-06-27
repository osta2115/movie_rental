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

        categoryChangeTest();
//        addProductTest();
//        productRepositoryHibernate.getProductById(11).ifPresent(System.out::println);
//        branchTest();
//        directorTest();
//        categoryTest();
//        pegiCategoriesTest();
//        carrierTest();



//        productRepositoryHibernate.removeCategory(Category.builder().title("Karykatura").build());
//        productRepositoryHibernate.deleteProductById(11);
//        productRepositoryHibernate.deleteProductById(43);
//        productRepositoryHibernate.getProductById(11).ifPresent(System.out::println);

        System.out.println("><><");
//        List<Product> allProducts = productRepositoryHibernate.getAllProducts();
//        allProducts.forEach(System.out::println);

    }

    private static void categoryChangeTest() {
        productRepositoryHibernate.getListOfProductWithGivenTitle("to jest ***** dramat").forEach(System.out::println);
        Category category = new Category();
        category.setTitle("test zmiany kategorii");
        System.out.println(productRepositoryHibernate.changeProductCategory(7, category));
        System.out.println(productRepositoryHibernate.changeProductCategory(300, category));
    }

    private static void carrierTest() {
        Carrier carrier1 = new Carrier();
        carrier1.setDescription("płyta");
        Carrier carrier2 = new Carrier();
        carrier2.setDescription("taśma");
        Carrier carrier3 = new Carrier();
        carrier3.setDescription("kaseta");

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
        PegiCategory pegi14 =new PegiCategory();
        pegi14.setTitle("14");
        PegiCategory pegi18 =new PegiCategory();
        pegi18.setTitle("18");
        PegiCategory pegi4 = new PegiCategory();
        pegi14.setTitle("4");

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
        Category category1 = new Category();
        category1.setTitle("Komedia");
        Category category2 = new Category();
        category2.setTitle("Tragedia");
        productRepositoryHibernate.addCategory(category1);
        productRepositoryHibernate.addCategory(category1);
        productRepositoryHibernate.addCategory(category2);
        productRepositoryHibernate.getCategory(category1);
        productRepositoryHibernate.getCategory(category2);
        productRepositoryHibernate.removeCategory(category2);
        productRepositoryHibernate.getCategory(category2);
    }

    private static void directorTest() {
        Director director1 = new Director();
        director1.setFirstName("Janina");
        director1.setLastName("Jakaś");
        Director director2 = new Director();
        director2.setFirstName("Jan");
        director2.setLastName("Jakiś");
        productRepositoryHibernate.addDirector(director1);
        productRepositoryHibernate.addDirector(director2);
        productRepositoryHibernate.getDirector(director1);
        productRepositoryHibernate.getDirector(director2);
        productRepositoryHibernate.removeDirector(director2);
        productRepositoryHibernate.getDirector(director1);
        productRepositoryHibernate.getDirector(director2);
    }

    private static void branchTest() {
        Branch branch1 = new Branch();
        branch1.setName("Gdzies");
        branch1.setAdres("ulica 1");
        branch1.setPostalCode("90-123");

        Branch branch2 = new Branch();
        branch2.setName("Gdzies 2");
        branch2.setAdres("inna ulica");
        branch2.setPostalCode("45-123");


        productRepositoryHibernate.addBranch(branch1);
        productRepositoryHibernate.addBranch(branch2);
        System.out.println(productRepositoryHibernate.getBranch(branch1));
        productRepositoryHibernate.removeBranch(branch1);
        productRepositoryHibernate.removeBranch(branch1);
    }

    private static void addProductTest() {
        var product1 = buildProductWithName("Poczwara");
        var product2 = buildProductWithName("Taki se film 3");
        var product3 = buildProductWithName("Taki se film: powrót");
        productRepositoryHibernate.createProduct(product1);
        productRepositoryHibernate.createProduct(product2);
        productRepositoryHibernate.createProduct(product3);

    }

    static Product buildProductWithName(String name) {
        Branch branch = new Branch();
        branch.setName("Gdzies");
        branch.setAdres("ulica");
        branch.setPostalCode("12-345");

        Carrier carrier = new Carrier();
        carrier.setDescription("taśma");

        Category category = new Category();
        category.setTitle("DRAMAT");

        PegiCategory pegiCategory = new PegiCategory();
        pegiCategory.setTitle("+18");
        Director director = new Director();
                director.setFirstName("Jan");
                director.setLastName("Janowski");

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

