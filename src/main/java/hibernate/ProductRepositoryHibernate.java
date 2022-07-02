package hibernate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tables.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ProductRepositoryHibernate implements ProductsRepository {
    private final EntityManager entityManager;

    @Override
    public void createProduct(Product product) {
        if (getBranch(product.getBranch()).isPresent()) {
            product.setBranch(getBranch(product.getBranch()).get());
        } else addBranch(product.getBranch());

        if (getCarrier(product.getCarrier()).isPresent()) {
            product.setCarrier(getCarrier(product.getCarrier()).get());
        } else addCarrier(product.getCarrier());

        if (getCategory(product.getCategory()).isPresent()) {
            product.setCategory(getCategory(product.getCategory()).get());
        } else addCategory(product.getCategory());

        if (getDirector(product.getDirector()).isPresent()) {
            product.setDirector(getDirector(product.getDirector()).get());
        } else addDirector(product.getDirector());

        if (getPegiCategory(product.getPegiCategory()).isPresent()) {
            product.setPegiCategory(getPegiCategory(product.getPegiCategory()).get());
        } else addPegiCategory(product.getPegiCategory());

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteProductById(Integer id) {
        try {
            var selectProductsById = """
                    SELECT p FROM Product p
                    WHERE p.id =  :id
                    """;
            var query = entityManager.createQuery(selectProductsById, Product.class);
            query.setParameter("id", id);

            var product = Optional.of(query.getSingleResult());

            entityManager.getTransaction().begin();
            entityManager.remove(product.get());
            entityManager.getTransaction().commit();

        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing product. product id: {}", id);
        }
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        try {
            var selectproductsbyid = """
                    SELECT p FROM Product p
                    WHERE p.id =  :id
                    """;
            var query = entityManager.createQuery(selectproductsbyid, Product.class);
            query.setParameter("id", id);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            log.warn("No product with id: {} found", id);
            return Optional.empty();
        }
    }

    @Override
    public List<Product> getListOfProductWithGivenTitle(String title) {
        var sqlStatement = """
                SELECT p FROM Product p
                WHERE p.title = :title
                """;
        TypedQuery<Product> query = entityManager.createQuery(sqlStatement, Product.class);
        query.setParameter("title", title);

        return query.getResultList();
    }

    @Override
    public List<Product> getListOfProductWithGivenCarrier(String title) {

        List<Product> list = getAllProducts();
        return list.stream()
                .filter(p -> p.getCarrier().getDescription().equalsIgnoreCase(title))
                .toList();
    }

    @Override
    public List<Product> getAllProducts() {

        try {
            var selectAllProducts = """
                    SELECT NEW tables.Product (p.id, p.title, p.category, p.director, p.pegiCategory, p.carrier, p.branch, p.releaseDate)
                                    
                    FROM Product p
                    """;
            var query = entityManager.createQuery(selectAllProducts, Product.class);
            return query.getResultList();
        } catch (NoResultException e) {
            log.info("No products in database!");
        }
        return List.of();
    }

    @Override
    public Optional<Product> changeProductCategory(Integer id, Category category) {
        Optional<Product> exstingProduct = getProductById(id);
        Category existigCategory = addCategory(category);

        try {
            entityManager.getTransaction().begin();
            exstingProduct.ifPresent(p -> p.setCategory(existigCategory));
            entityManager.getTransaction().commit();

            return exstingProduct;
        } catch (NoSuchElementException e) {
            log.warn("No product with id {}", id);
            return Optional.empty();
        }

    }

    @Override
    public Optional<Product> changeProductBranch(Integer id, Branch branch) {
        Optional<Product> exstingProduct = getProductById(id);
        Branch existingBranch = addBranch(branch);

        try {
            entityManager.getTransaction().begin();
            exstingProduct.ifPresent(p -> p.setBranch(existingBranch));
            entityManager.getTransaction().commit();

            return exstingProduct;
        } catch (NoSuchElementException e) {
            log.warn("No product with id {}", id);
            return Optional.empty();
        }

    }

    @Override
    public Carrier addCarrier(Carrier carrier) {
        try {
            var selectSql = """
                    SELECT c FROM Carrier c
                    WHERE c.description = :description
                    """;
            var query = entityManager.createQuery(selectSql, Carrier.class);
            query.setParameter("description", carrier.getDescription());
            var existnigCarrier = Optional.ofNullable(query.getSingleResult());

            log.warn("Carrier with given name already exists: {}", carrier.getDescription());
            return existnigCarrier.get();

        } catch (NoResultException e) {
            entityManager.getTransaction().begin();
            entityManager.persist(carrier);
            entityManager.getTransaction().commit();
            log.info("Carrier type added: {}", carrier.getDescription());
            return carrier;
        }
    }

    @Override
    public boolean removeCarrier(Carrier carrier) {
        try {
            var selectSql = """
                    SELECT c FROM Carrier c
                    WHERE c.description = :description
                    """;
            var query = entityManager.createQuery(selectSql, Carrier.class);
            query.setParameter("description", carrier.getDescription());
            var existingCarrier = query.getSingleResult();
            entityManager.getTransaction().begin();
            entityManager.remove(existingCarrier);
            entityManager.getTransaction().commit();
            log.info("Carrier type: {},deleted", carrier.getDescription());
            return true;
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing carrier type {}", carrier.getDescription());
            return false;
        }
    }

    @Override
    public Optional<Carrier> getCarrier(Carrier carrier) {
        try {
            var selectSql = """
                     SELECT c FROM Carrier c
                    WHERE c.description = :description
                    """;
            var query = entityManager.createQuery(selectSql, Carrier.class);
            query.setParameter("description", carrier.getDescription());
            Optional<Carrier> singleResult = Optional.ofNullable(query.getSingleResult());
            if (singleResult.isPresent()) {
                log.info("Carrier type {} found ", carrier.getDescription());
            }
            return singleResult;
        } catch (NoResultException e) {
            log.info("No CarrierType: {}", carrier.getDescription());
            return Optional.empty();
        }
    }

    @Override
    public PegiCategory addPegiCategory(PegiCategory pegiCategory) {
        try {
            var selectSql = """
                    SELECT pc FROM PegiCategory pc
                    WHERE pc.title = :title
                    """;
            var query = entityManager.createQuery(selectSql, PegiCategory.class);
            query.setParameter("title", pegiCategory.getTitle());
            var existingCategory = Optional.ofNullable(query.getSingleResult());
            log.warn("PEGI Category with given name already exists: {}", pegiCategory.getTitle());
            return existingCategory.get();
        } catch (NoResultException e) {
            entityManager.getTransaction().begin();
            entityManager.persist(pegiCategory);
            entityManager.getTransaction().commit();
            log.info("Category added: {}", pegiCategory.getTitle());
            return pegiCategory;
        }
    }

    @Override
    public boolean removePegiCategory(PegiCategory pegiCategory) {
        try {
            var selectSql = """
                    SELECT pc FROM PegiCategory pc
                    WHERE pc.title = :title
                    """;
            var query = entityManager.createQuery(selectSql, PegiCategory.class);
            query.setParameter("title", pegiCategory.getTitle());
            var existingCategory = query.getSingleResult();
            entityManager.getTransaction().begin();
            entityManager.remove(existingCategory);
            entityManager.getTransaction().commit();
            log.info("PEGI Category: {},deleted", pegiCategory.getTitle());
            return true;
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing PEGI Category {}", pegiCategory.getTitle());
            return false;
        }
    }

    @Override
    public Optional<PegiCategory> getPegiCategory(PegiCategory pegiCategory) {
        try {
            var selectSql = """
                    SELECT pc FROM PegiCategory pc
                    WHERE pc.title = :title
                    """;
            var query = entityManager.createQuery(selectSql, PegiCategory.class);
            query.setParameter("title", pegiCategory.getTitle());
            Optional<PegiCategory> singleResult = Optional.ofNullable(query.getSingleResult());
            if (singleResult.isPresent()) {
                log.info("PEGI Category {} found ", pegiCategory.getTitle());
            }
            return singleResult;
        } catch (NoResultException e) {
            log.info("No PEGI Category: {}", pegiCategory.getTitle());
            return Optional.empty();
        }
    }

    @Override
    public Category addCategory(Category category) {
        try {
            var selectSql = """
                    SELECT c FROM Category c
                    WHERE c.title = :title
                    """;
            var query = entityManager.createQuery(selectSql, Category.class);
            query.setParameter("title", category.getTitle());
            var existingCategory = query.getSingleResult();
            log.warn("Category with given name already exists: {}", category.getTitle());
            return existingCategory;
        } catch (NoResultException e) {
            entityManager.getTransaction().begin();
            entityManager.persist(category);
            entityManager.getTransaction().commit();
            log.info("Category added: {}", category.getTitle());
            return category;
        }
    }

    @Override
    public boolean removeCategory(Category category) {
        try {
            var selectSql = """
                    SELECT c FROM Category c
                    WHERE c.title = :title
                    """;
            var query = entityManager.createQuery(selectSql, Category.class);
            query.setParameter("title", category.getTitle());
            var existingCategory = query.getSingleResult();
            entityManager.getTransaction().begin();
            entityManager.remove(existingCategory);
            entityManager.getTransaction().commit();
            log.info("Category titled: {},deleted", category.getTitle());
            return true;
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing Category {}", category.getTitle());
            return false;
        }
    }

    @Override
    public Optional<Category> getCategory(Category category) {
        try {
            var selectSql = """
                    SELECT c FROM Category c
                    WHERE c.title = :title
                    """;
            var query = entityManager.createQuery(selectSql, Category.class);
            query.setParameter("title", category.getTitle());
            log.info("Category {} found ", category.getTitle());
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            log.info("No Category titled {}", category.getTitle());
            return Optional.empty();
        }
    }

    @Override
    public Director addDirector(Director director) {
        try {
            var selectSql = """
                    SELECT d FROM Director d
                    WHERE d.firstName = :firstName
                    AND d.lastName = :lastName
                    """;
            var query = entityManager.createQuery(selectSql, Director.class);
            query.setParameter("firstName", director.getFirstName());
            query.setParameter("lastName", director.getLastName());
            Optional<Director> existingDirector = Optional.ofNullable(query.getSingleResult());
            log.warn("Director with given name already exists: {} {}"
                    , director.getLastName(), director.getLastName());
            return existingDirector.get();

        } catch (NoResultException e) {
            entityManager.getTransaction().begin();
            entityManager.persist(director);
            entityManager.getTransaction().commit();
            log.info("Director added: {}, {} {}", director.getId(), director.getLastName(), director.getLastName());
            return director;
        }
    }

    @Override
    public boolean removeDirector(Director director) {
        try {
            var selectSql = """
                    SELECT d FROM Director d
                    WHERE d.firstName = :firstName
                    AND d.lastName = :lastName
                    """;
            var query = entityManager.createQuery(selectSql, Director.class);
            query.setParameter("firstName", director.getFirstName());
            query.setParameter("lastName", director.getLastName());
            var existingDirector = query.getSingleResult();
            entityManager.getTransaction().begin();
            entityManager.remove(existingDirector);
            entityManager.getTransaction().commit();
            log.info("Director with id: {}, {}, {} deleted",
                    director.getId(), director.getLastName(), director.getLastName());
            return true;
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing Director {}, {}"
                    , director.getFirstName(), director.getLastName());
            return false;
        }
    }

    @Override
    public Optional<Director> getDirector(Director director) {
        try {
            var selectSql = """
                    SELECT d FROM Director d
                    WHERE d.firstName = :firstName
                    AND d.lastName = :lastName
                    """;
            var query = entityManager.createQuery(selectSql, Director.class);
            query.setParameter("firstName", director.getFirstName());
            query.setParameter("lastName", director.getLastName());
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            log.info("No Director named {}", director.getLastName());
            return Optional.empty();
        }
    }

    @Override
    public Branch addBranch(Branch branch) {
        String postalCode = branch.getPostalCode();
        try {
            var selectSql = """
                    SELECT b FROM Branch b
                    WHERE b.postalCode =  :postalCode
                    """;
            var query = entityManager.createQuery(selectSql, Branch.class);
            query.setParameter("postalCode", postalCode);

            Optional<Branch> existingBranch = Optional.ofNullable(query.getSingleResult());

            log.warn("Branch with given postal code already exists: {}", postalCode);
            return existingBranch.get();
        } catch (NoResultException e) {
            entityManager.getTransaction().begin();
            entityManager.persist(branch);
            entityManager.getTransaction().commit();
            log.info("Branch added: {}", branch);
            return branch;
        }
    }

    @Override
    public boolean removeBranch(Branch branch) {
        String postalCode = branch.getPostalCode();
        try {
            var selectSql = """
                    SELECT b FROM Branch b
                    WHERE b.postalCode =  :postalCode
                    """;
            var query = entityManager.createQuery(selectSql, Branch.class);
            query.setParameter("postalCode", postalCode);
            var existingBranch = query.getSingleResult();

            entityManager.getTransaction().begin();
            entityManager.remove(existingBranch);
            entityManager.getTransaction().commit();
            log.info("Branch {}, {} deleted", branch.getName(), branch.getPostalCode());
            return true;
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing Branch {}, {}, {}",
                    branch.getName(),
                    branch.getPostalCode(),
                    branch.getAdres());
            return false;
        }
    }

    @Override
    public Optional<Branch> getBranch(Branch branch) {
        try {
            String postalCode = branch.getPostalCode();
            var selectSql = """
                    SELECT b FROM Branch b
                    WHERE b.postalCode =  :postalCode
                    """;
            var query = entityManager.createQuery(selectSql, Branch.class);
            query.setParameter("postalCode", postalCode);
            var existingBranch = query.getSingleResult();
            return Optional.of(existingBranch);
        } catch (
                NoResultException e) {
            log.info("No branch {} {} {} found", branch.getName(), branch.getAdres(), branch.getPostalCode());
            return Optional.empty();
        }
    }

    @Override
    public List<Product> getListOfProductWithGivenCategory(String title) {
        List<Product> list = getAllProducts();
        return list.stream()
                .filter(p -> p.getCategory().getTitle().equalsIgnoreCase(title))
                .toList();
    }

    public List<Category> getListOfallCategories() {
        List<Product> list = getAllProducts();
        return list.stream()
                .map(Product::getCategory)
                .toList();
    }

    public List<Carrier> getListOfAllCarerTypes() {
        List<Product> list = getAllProducts();
        return list.stream()
                .map(Product::getCarrier)
                .toList();
    }


}
