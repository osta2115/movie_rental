package hibernate;

import java.sql.Date;

public interface RentsRepository {

    boolean isProductAvailableNow(Integer bookId, Date date);

    boolean isProductAvailableAtGivenDate(Integer bookId, Date date);



    Date firstAvailableDate(Integer bookId);
}
