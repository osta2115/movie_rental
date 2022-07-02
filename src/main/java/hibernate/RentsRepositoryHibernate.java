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
    public void createRent(Rent rent) throws SQLException {
        entityManager.getTransaction().begin();
        entityManager.persist(rent);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Rent> getAllRents() throws SQLException {
        String selectAllRents = """
                select new tables.Rent(r.id, r.product, r.client, r.rentDate, r.returnDate)
                from Rent r
                """;
        var query = entityManager.createQuery(selectAllRents, Rent.class);
        return query.getResultList();
    }

    @Override
    public List<Rent> getAllProductRents(Product product) throws SQLException {
        return getAllRents().stream()
                .filter(rent -> rent.getProduct().equals(product))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isProductAvailableNow(Integer id) throws SQLException {
        entityManager.getTransaction().begin();
        String selectAvailableProductNowById = "select p from Product p where p.id = :id";
        var query = entityManager.createQuery(selectAvailableProductNowById,
                Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();
        List<Rent> productRents = getAllProductRents(product);
        for (Rent rent : productRents){
            if (LocalDate.now().isAfter(rent.getReturnDate())) {
                log.info("Product with id: {} is available now", id);
                entityManager.getTransaction().commit();
                return true;
            }
        }
        log.info("Product with id: {} is not available now", id);
        entityManager.getTransaction().commit();
        return false;

    }


    @Override
    public boolean isProductAvailableAtGivenDate(Integer id, LocalDate date) throws SQLException {
        entityManager.getTransaction().begin();
        String selectAvailableProductNowById = "select p from Product p where p.id = :id";
        var query = entityManager.createQuery(selectAvailableProductNowById,
                Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();
        List<Rent> productRents = getAllProductRents(product);
        for (Rent rent : productRents){
            if (date.isAfter(rent.getReturnDate())) {
                log.info("Product with id: {} is available at: {}", id, date);
                entityManager.getTransaction().commit();
                return true;
            }
        }
        log.info("Product with id: {} is not available at: {}", id, date);
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public LocalDate firstAvailableDate(Integer id) throws SQLException {
        if (!isProductAvailableNow(id)){
            entityManager.getTransaction().begin();
            String selectProduct = "select p from Product p where p.id = :id";
            var query = entityManager.createQuery(selectProduct, Product.class);
            query.setParameter("id", id);
            Product product = query.getSingleResult();
            List<Rent> productRents = getAllProductRents(product);
            List<LocalDate> closestReturnDate = productRents.stream()
                    .map(Rent::getReturnDate)
                    .sorted()
                    .limit(1)
                    .toList();
            log.info("Product with id: {} will be available at: {}", id, closestReturnDate.get(0).plusDays(1));
            entityManager.getTransaction().commit();
            return closestReturnDate.get(0).plusDays(1);
        } else {
            log.info("Product with id: {} is available now", id);
            return LocalDate.now();
        }
    }
}
