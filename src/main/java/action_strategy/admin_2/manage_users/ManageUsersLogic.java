package action_strategy.admin_2.manage_users;

import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class ManageUsersLogic {

    public void startAdminUserManagementPanel() {
        displayWelcomeMsg();
        adminUserManagementScreen();
    }

    private void adminUserManagementScreen() {
        optionPane();
        ManageUsersContext manageUsersContext = new ManageUsersContext();
        Strategy operation = manageUsersContext.operation(StrategyPicker.getOptionFromScanner());
        operation.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("-<--------- USER MANAGEMENT PANEL ---------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("1. Add user");
        System.out.println("2. Remove user");
        System.out.println("3. Change user permission");
        System.out.println("4. Modify user data");
        System.out.println("5. Return to previous menu");
        System.out.println("<------------------------------------------->");
    }
}
