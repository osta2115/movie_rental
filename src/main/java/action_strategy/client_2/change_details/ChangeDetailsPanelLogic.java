package action_strategy.client_2.change_details;

import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class ChangeDetailsPanelLogic {

    public void startChangeDetailsPanelPanel() {
        displayWelcomeMsg();
        userManageScreen();
    }

    private void userManageScreen() {
        optionPane();
        ChangeDetailsPanelContext userManageContext = new ChangeDetailsPanelContext();
        Strategy operation = userManageContext.operation(StrategyPicker.getOptionFromScanner());
        operation.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("<------ CHANGE YOUR CONTACT DETAILS -------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("1. Change password");
        System.out.println("2. Change address");
        System.out.println("3. Change email");
        System.out.println("4. Change phone number");
        System.out.println("5. Return to previous menu");
        System.out.println("<------------------------------------------->");
    }
}
