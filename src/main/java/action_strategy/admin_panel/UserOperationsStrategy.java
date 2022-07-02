package action_strategy.admin_panel;

import action_strategy.Strategy;
import action_strategy.admin_2.manage_users.ManageUsersLogic;

public class UserOperationsStrategy implements Strategy {

    @Override
    public void algorithm() {
        new ManageUsersLogic().startAdminUserManagementPanel();
    }
}
