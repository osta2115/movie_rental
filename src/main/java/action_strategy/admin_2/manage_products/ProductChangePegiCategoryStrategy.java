package action_strategy.admin_2.manage_products;

import action_strategy.Strategy;

public class ProductChangePegiCategoryStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("change product pegi category");
        new ManageProductLogic().startAdminProductManagementPanel();
    }
}
