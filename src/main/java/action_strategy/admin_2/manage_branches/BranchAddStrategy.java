package action_strategy.admin_2.manage_branches;

import action_strategy.Strategy;

public class BranchAddStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("Branch add method");
        new ManageBranchesLogic().startAdminBranchManagementPanel();
    }
}
