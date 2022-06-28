package action_strategy.login_panel;

import action_strategy.StrategyCommons;
import action_strategy.Context;
import action_strategy.StrategyPicker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginContext implements Context {
    private static final LoginContext INSTANCE = new LoginContext();

    private LoginContext() {
    }

    public static LoginContext getInstance() {
        return INSTANCE;
    }

    public void startLoginPanel() {
        displayWelcomeMsg();
        LoginContextScreen();
    }

    public void LoginContextScreen() {
        optionPane();
        operation(StrategyPicker.getOptionFromScanner());
    }

    @Override
    public void operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1 -> login();
            case OPTION_2 -> register();
            case OPTION_3 -> StrategyCommons.exitShop();
            default -> {
                log.info("Wrong - enter command again");
                operation(StrategyPicker.getOptionFromScanner());
            }
        }
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

    private void register() {
        // TODO register method
        System.out.println("Register method //not yet implemented//");
        System.out.println("Please log in:");
        login();
    }

    private void login() {
        // TODO login method
        System.out.println("Login method //not yet implemented//");
    }
}
