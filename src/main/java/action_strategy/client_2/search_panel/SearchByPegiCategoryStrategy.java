package action_strategy.client_2.search_panel;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.Product;

import java.util.List;
import java.util.Optional;

public class SearchByPegiCategoryStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE PEGI CATEGORIES ------>");
        repository.getListOfAllPegiCategories().stream()
                .distinct()
                .forEach(c -> System.out.println(c.getTitle()));
        System.out.println("Enter PEGI category:");
        String title = MyScanner.getText();

        List<Product> resultList = repository.getListOfProductWithGivenPegiCategory(title);

        if (resultList.isEmpty()) {
            System.out.println("No product with given PEGI category. " +
                    "\nReturning to previous menu");
            MyScanner.pressAnyKeyToContinue();
            new SearchPanelLogic().startAdminUserManagementPanel();
        }
        resultList.forEach(System.out::println);
        System.out.println("Do you want to rent one of these this ?");
        if (MyScanner.yesOrNo()) {
            //TODO Add rent method
            System.out.println("Insert id of product You want to rent");
            Optional<Product> productToRent = repository.getProductById(MyScanner.getInt());
            System.out.println(productToRent);

            System.out.println("RENTING PRODUCT METHOD HERE");
        } else System.out.println("Returning to previous menu");
        MyScanner.pressAnyKeyToContinue();
        new SearchPanelLogic().startAdminUserManagementPanel();
    }
}
