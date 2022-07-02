package action_strategy.admin_2.manage_branches;

import action_strategy.Strategy;

public class BramchRemoveStrategy implements Strategy {
    @Override
    public void algorithm() {

        //TODO
        System.out.println("Branch remove method");
        new ManageBranchesLogic().startAdminBranchManagementPanel();
    }
}
