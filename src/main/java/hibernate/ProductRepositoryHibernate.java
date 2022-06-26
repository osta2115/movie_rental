package hibernate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tables.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ProductRepositoryHibernate implements ProductsRepository {
    private final EntityManager entityManager;

    @Override
    public void createProduct(Product product) throws SQLException {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteProductById(Integer id) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            var selectProductsById = """
                    SELECT p FROM Product p
                    WHERE p.id =  :id
                    """;
            var query = entityManager.createQuery(selectProductsById, Product.class);
            query.setParameter("id", id);
            var product = query.getSingleResult();
            entityManager.remove(product);
            entityManager.getTransaction().commit();

        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing product. product id: {}", id);
        }
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        var selectproductsbyid = """
                SELECT p FROM Product p
                WHERE p.id =  :id
                """;
        var query = entityManager.createQuery(selectproductsbyid, Product.class);
        query.setParameter("id", id);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Product getProductName(String name) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        var selectAllProducts = """
                SELECT NEW tables.Product (p.id, p.title)
                
                FROM Product p
                """;
        var query = entityManager.createQuery(selectAllProducts, Product.class);
        return query.getResultList();
    }

    @Override
    public boolean changeProductCategory(Integer id, Category category) {
        return false;
    }

    @Override
    public boolean changeProductBranch(Integer id, Branch branch) {
        return false;
    }

    @Override
    public boolean addPegiCategory(PegiCategory pegiCategory) {
        return false;
    }

    @Override
    public boolean removePegiCategory(PegiCategory pegiCategory) {
        return false;
    }

    @Override
    public boolean addCategory(Category category) {
        return false;
    }

    @Override
    public boolean removeCategory(Category category) {
        return false;
    }

    @Override
    public Optional<Category> findCategory(Category category) {
        try {
            var selectSql = """
                    SELECT c FROM Category c
                    WHERE c.title = :title
                    """;
            var query = entityManager.createQuery(selectSql, Category.class);
            query.setParameter("firstName", category.getTitle());
            log.info("Category {} found ", category.getTitle());
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            log.info("No Director named {}", category.getTitle());
            return Optional.empty();
        }
    }


    @Override
    public void addDirector(Director director) {
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
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing Director {}, {}, {}",
                    director.getId(), director.getLastName(), director.getLastName());
        }
    }

    @Override
    public void removeDirector(Director director) {
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
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing Director {}, {}"
                    , director.getFirstName(), director.getLastName());
        }
    }

    @Override
    public Optional<Director> findDirector(Director director){
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
    public void addBranch(Branch branch) {
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

        } catch (NoResultException e) {
            entityManager.getTransaction().begin();
            entityManager.persist(branch);
            entityManager.getTransaction().commit();
            log.info("Branch added: {}", branch);
        }
    }

    @Override
    public void removeBranch(Branch branch) {
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
        } catch (NoResultException e) {
            log.warn("Cannot delete non-existing Branch {}, {}, {}",
                    branch.getName(),
                    branch.getPostalCode(),
                    branch.getAdres());
        }
    }

    @Override
    public Optional<Branch> findBranch(Branch branch) {
        String postalCode = branch.getPostalCode();
        var selectSql = """
                    SELECT b FROM Branch b
                    WHERE b.postalCode =  :postalCode
                    """;
        var query = entityManager.createQuery(selectSql, Branch.class);
        query.setParameter("postalCode", postalCode);
        var existingBranch = query.getSingleResult();
        return Optional.of(existingBranch);
    }
}
