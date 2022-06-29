package action_strategy.admin_2.manage_products;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class ManageProductLogic {

    public void startAdminProductManagementPanel() {
        displayWelcomeMsg();
        adminProductManagementScreen();
    }

    private void adminProductManagementScreen() {
        optionPane();
        Context manageUsersContext = new ManageProductsContext();
        Strategy strategy = manageUsersContext.operation(StrategyPicker.getOptionFromScanner());
        strategy.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("-<--------- PRODUCT MANAGEMENT PANEL ---------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("1. Add product");
        System.out.println("2. Remove product");
        System.out.println("3. Change product branch");
        System.out.println("4. Change product Category");
        System.out.println("5. Change product PEGI Category");
        System.out.println("6. Return to previous menu");
        System.out.println("<------------------------------------------->");
    }
}
