package hibernate;

import java.sql.Date;

public class RentsRepositoryHibernate implements RentsRepository{
    @Override
    public boolean isProductAvailableNow(Integer bookId) {
        return false;
    }

    @Override
    public boolean isProductAvailableAtGivenDate(Integer bookId, Date date) {
        return false;
    }

    @Override
    public Date firstAvailableDate(Integer bookId) {
        return null;
    }
}
