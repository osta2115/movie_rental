package movie_rental;

import action_strategy.login_panel.LoginLogic;
import hibernate.ProductRepositoryHibernate;
import tables.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class MovieRentalMain {

    public static void main(String[] args) {
        LoginLogic.getInstance().startLoginPanel();
    }
}
