package action_strategy.admin_2.manage_users;

import action_strategy.Strategy;

public class UserModifyStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("user modify method");
        new ManageUsersLogic().startAdminUserManagementPanel();
    }
}
