package action_strategy.admin_2.manage_products;

import action_strategy.Strategy;

public class ProductAddStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("Product adding method");
        new ManageProductLogic().startAdminProductManagementPanel();
    }
}
