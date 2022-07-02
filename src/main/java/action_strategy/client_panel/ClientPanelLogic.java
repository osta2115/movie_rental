package action_strategy.client_panel;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class ClientPanelLogic {
    private static final ClientPanelLogic INSTANCE = new ClientPanelLogic();

    private ClientPanelLogic() {
    }

    public static ClientPanelLogic getInstance() {
        return INSTANCE;
    }

    public void startClientPanel() {
        displayWelcomeMsg();
        CientPanelContextScreen();
    }

    private void CientPanelContextScreen() {
        optionPane();
        Context clientPanelContext = new ClientPanelContext();
        Strategy strategy = clientPanelContext.operation(StrategyPicker.getOptionFromScanner());
        strategy.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("<-------------  CLIENT PANEL  -------------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("1. Search and rent");
        System.out.println("2. Change Account Details");
        System.out.println("3. LogOut");
        System.out.println("<------------------------------------------->");
    }
}
