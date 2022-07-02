package action_strategy.admin_2.manage_branches;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class ManageBranchesLogic {

    public void startAdminBranchManagementPanel() {
        displayWelcomeMsg();
        adminBranchManagementScreen();
    }

    private void adminBranchManagementScreen() {
        optionPane();
        Context manageBranchesContext = new ManageBranchesContext();
        Strategy strategy = manageBranchesContext.operation(StrategyPicker.getOptionFromScanner());
        strategy.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("-<-------- BRANCH MANAGEMENT PANEL --------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("1. Add branch");
        System.out.println("2. Remove branch");
        System.out.println("3. Return to previous menu");
        System.out.println("<------------------------------------------->");
    }
}
