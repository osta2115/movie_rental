package action_strategy.login_panel;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginLogic {
    private static final LoginLogic INSTANCE = new LoginLogic();

    private LoginLogic() {
    }

    public static LoginLogic getInstance() {
        return INSTANCE;
    }

    public void startLoginPanel() {
        displayWelcomeMsg();
        LoginContextScreen();
    }

    private void LoginContextScreen() {
        optionPane();
        Context loginContext = new LoginContext();
        Strategy operation = loginContext.operation(StrategyPicker.getOptionFromScanner());
        operation.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("<--------- WELCOME TO MOVIE RENTAL --------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("3. Exit movie rental");
        System.out.println("<------------------------------------------->");
    }
}
