package hibernate;

import java.sql.Date;

public interface RentsRepository {

    boolean isProductAvailableNow(Integer bookId);

    boolean isProductAvailableAtGivenDate(Integer bookId, Date date);



    Date firstAvailableDate(Integer bookId);
}
