package hibernate;

import tables.Product;
import tables.Rent;

import java.time.LocalDate;
import java.util.List;

public interface RentsRepository {

    void createRent(Rent rent);

    List<Rent> getAllRents();

    List<Rent> getAllProductRents(Product product);

    boolean isProductAvailableNow(Integer id);

    boolean isProductAvailableAtGivenDate(Integer id, LocalDate date);

    LocalDate firstAvailableDate(Integer id);
}
