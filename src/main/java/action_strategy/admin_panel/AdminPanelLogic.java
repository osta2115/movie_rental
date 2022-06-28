package action_strategy.admin_panel;

import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class AdminPanelLogic {
    private static final AdminPanelLogic INSTANCE = new AdminPanelLogic();

    private AdminPanelLogic() {
    }

    public static AdminPanelLogic getInstance() {
        return INSTANCE;
    }
    public void startAdminPanel() {
        displayWelcomeMsg();
        AdminPanelContextScreen();
    }

    private void AdminPanelContextScreen() {
        optionPane();
        AdminPanelContext adminPanelContext = new AdminPanelContext();
        Strategy operation = adminPanelContext.operation(StrategyPicker.getOptionFromScanner());
        operation.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("<--------------  ADMIN PANEL  -------------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("1. Manage users");
        System.out.println("2. Manage products");
        System.out.println("3. Manage company branches");
        System.out.println("3. LogOut");
        System.out.println("<------------------------------------------->");
    }
}
