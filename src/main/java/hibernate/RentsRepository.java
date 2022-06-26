package hibernate;

import tables.Product;
import tables.Rent;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface RentsRepository {

    List<Rent> getAllRents() throws SQLException;

    boolean isProductAvailableNow(Integer id) throws SQLException;;

    boolean isProductAvailableAtGivenDate(Integer id, LocalDate date) throws SQLException;;

    LocalDate firstAvailableDate(Integer bookId) throws SQLException;;
}
