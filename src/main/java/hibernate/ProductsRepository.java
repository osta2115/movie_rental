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

    boolean addPegiCategory(PegiCategory pegiCategory);
    boolean removePegiCategory(PegiCategory pegiCategory);

    boolean addCategory(Category category);
    boolean removeCategory(Category category);

    boolean addDirector(Director director);
    boolean removeDirector(Director director);

    boolean addBranch(Branch branch);
    void removeBranch(Branch branch);


}
