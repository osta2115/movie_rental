package action_strategy.admin_2.manage_users;

import action_strategy.Strategy;

public class UserToggleAdminStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("admin permission toggle method");
        new ManageUsersLogic().startAdminUserManagementPanel();
    }
}
