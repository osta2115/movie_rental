package action_strategy.admin_2.manage_users;

import action_strategy.Strategy;

public class UserRemoveStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("remove user method");
        new ManageUsersLogic().startAdminUserManagementPanel();
    }
}
