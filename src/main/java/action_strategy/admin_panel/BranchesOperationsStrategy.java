package action_strategy.admin_panel;

import action_strategy.Strategy;
import action_strategy.admin_2.manage_branches.ManageBranchesLogic;

public class BranchesOperationsStrategy implements Strategy {
    @Override
    public void algorithm() {
        new ManageBranchesLogic().startAdminBranchManagementPanel();
    }
}
