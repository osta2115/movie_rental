package action_strategy.client_2.search_panel;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.Product;

import java.util.List;
import java.util.Optional;

public class SearchByReleaseYearStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF YEARS OF MOVIES (?) ------------>");
        repository.GetListOfAllYears().stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("Enter year of production:");
        String year = MyScanner.getText();

        List<Product> resultList = repository.getListOfProductCreatedINGivenYear(year);

        if (resultList.isEmpty()) {
            System.out.println("No product created in given year. \nReturning to previous menu");
            MyScanner.pressAnyKeyToContiunue();
            new SearchPanelLogic().startAdminUserManagementPanel();
        }
        resultList.forEach(System.out::println);
        System.out.println("Do you want to rent one of those?");
        if (MyScanner.yesOrNo()) {
            //TODO Add rent method
            System.out.println("Insert id of product You want to rent");
            Optional<Product> productToRent = repository.getProductById(MyScanner.getInt());
            System.out.println(productToRent);

            System.out.println("RENTING PRODUCT METHOD HERE");
        } else System.out.println("Returning to previous menu");
        MyScanner.pressAnyKeyToContiunue();
        new SearchPanelLogic().startAdminUserManagementPanel();
    }

}
