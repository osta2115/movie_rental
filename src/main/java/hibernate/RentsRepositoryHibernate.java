package hibernate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tables.Product;
import tables.Rent;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
public class RentsRepositoryHibernate implements RentsRepository{

    private final EntityManager entityManager;

    @Override
    public List<Rent> getAllRents() throws SQLException {
        String selectAllRents = """
                select from tables.Rent(r.id, r.client, r.product, r.rentDate, r.returnDate)
                from Rent r
                """;
        var query = entityManager.createQuery(selectAllRents, Rent.class);
        return query.getResultList();
    }

    @Override
    public boolean isProductAvailableNow(Integer id) throws SQLException {
        entityManager.getTransaction().begin();
        String selectAvailableProductsNowById = "select p from Product p where p.id :id";
        var query = entityManager.createQuery(selectAvailableProductsNowById,
                Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();
        List<Rent> productRents = getAllProductRents(product);
        for (Rent rent : productRents){
            if (LocalDate.now().isBefore(rent.getReturnDate())) {
                log.info("Product with id: {} is available now", id);
                return true;
            }
        }
        log.info("Product with id: {} is available now", id);
        return false;
    }

    public List<Rent> getAllProductRents(Product product) throws SQLException {
        return getAllRents().stream()
                .filter(rent -> rent.getProduct().equals(product))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isProductAvailableAtGivenDate(Integer id, LocalDate date) throws SQLException {
        return false;
    }

    @Override
    public LocalDate firstAvailableDate(Integer bookId) throws SQLException {
        return null;
    }
}
