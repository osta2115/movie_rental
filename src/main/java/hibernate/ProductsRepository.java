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

    void addCarrier(Carrier carrier);
    void removeCarrier(Carrier carrier);
    Optional<Carrier> getCarrier(Carrier carrier);

    void addPegiCategory(PegiCategory pegiCategory);
    void removePegiCategory(PegiCategory pegiCategory);
    Optional<PegiCategory> getPegiCategory(PegiCategory pegiCategory);

    void addCategory(Category category);
    void removeCategory(Category category);
    Optional<Category> getCategory(Category category);

    void addDirector(Director director);
    void removeDirector(Director director);
    Optional<Director> getDirector(Director director);

    void addBranch(Branch branch);
    void removeBranch(Branch branch);
    Optional<Branch> getBranch(Branch branch);


}
