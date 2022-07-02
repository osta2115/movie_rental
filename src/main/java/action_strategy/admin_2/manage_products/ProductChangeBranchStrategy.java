package action_strategy.admin_2.manage_products;

import action_strategy.Strategy;

public class ProductChangeBranchStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println(" Product branch change method");
        new ManageProductLogic().startAdminProductManagementPanel();
    }
}
