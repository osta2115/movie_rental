package hibernate;

import lombok.RequiredArgsConstructor;
import tables.*;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductRepositoryHibernate implements ProductsRepository{
    private final EntityManager entityManager;

    @Override
    public void createProduct(Product product) throws SQLException {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean deleteProductById(Integer id) {
        return false;
    }

    @Override
    public Optional<Product> getProductBy(Integer id) {
        var selectProductsByID = """
                SELECT p FROM products p
                WHERE p.id =  :id
                """;
        var query = entityManager.createQuery(selectProductsByID, Product.class);
        query.setParameter("id", id);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Product getProductName(String name) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
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
    public boolean addDirector(Director director) {
        return false;
    }

    @Override
    public boolean removeDirector(Director director) {
        return false;
    }

    @Override
    public boolean addBranch(Branch branch) {
        return false;
    }

    @Override
    public boolean removeBranch(Branch branch) {
        return false;
    }
}
