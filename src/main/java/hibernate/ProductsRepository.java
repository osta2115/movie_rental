package hibernate;

import tables.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductsRepository {

    void createProduct(Product product) throws SQLException;
    void deleteProductById(Integer id) throws SQLException;
    Optional<Product> getProductById(Integer id);
    Product getProductName(String name);
    List<Product> getAllProducts();

    boolean changeProductCategory(Integer id, Category category);
    boolean changeProductBranch(Integer id, Branch branch);

    void addPegiCategory(PegiCategory pegiCategory);
    void removePegiCategory(PegiCategory pegiCategory);
    public Optional<PegiCategory> findPegiCategory(PegiCategory pegiCategory);

    void addCategory(Category category);
    void removeCategory(Category category);
    public Optional<Category> findCategory(Category category);

    void addDirector(Director director);
    void removeDirector(Director director);
    Optional<Director> findDirector(Director director);

    void addBranch(Branch branch);
    void removeBranch(Branch branch);
    Optional<Branch> findBranch(Branch branch);


}
