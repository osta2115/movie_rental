package action_strategy.client_2.search_panel;

import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class SearchPanelLogic {

    public void startAdminUserManagementPanel() {
        displayWelcomeMsg();
        adminUserManagementScreen();
    }

    private void adminUserManagementScreen() {
        optionPane();
        SearchPanelContext manageUsersContext = new SearchPanelContext();
        Strategy operation = manageUsersContext.operation(StrategyPicker.getOptionFromScanner());
        operation.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("-<------------ SEARCH AND RENT ------------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("<--SEARCH BY: ------------------------------>");
        System.out.println("1. Title");
        System.out.println("2. Director");
        System.out.println("3. Category");
        System.out.println("4. PEGI Category");
        System.out.println("5. Release year");
        System.out.println("6. Carrier type");
        System.out.println("7. Return to previous menu");
        System.out.println("<------------------------------------------->");
    }
}
