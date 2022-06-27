package action_strategy.login_panel;

import action_strategy.Commons;
import action_strategy.Context;
import action_strategy.StrategyPicker;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class LoginContext implements Context {

    public void welcomeScreen() {
        displayWelcomeMsg();
        char answer = optionPane();
//        operation();
    }

    @Override
    public void operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1 -> login();
            case OPTION_2 -> register();
            case OPTION_3 -> Commons.exitShop();
            default -> {
                log.info("Wrong answer use numbers shown on screen");
//                operation();
            }
        }
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("<--------- WELCOME TO MOVIE RENTAL --------->");
        System.out.println("<------------------------------------------->\n");
    }

    private char optionPane(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select option:");
        System.out.println("<------------------------------------------->\n");
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("3. Exit movie rental");
        System.out.println("<------------------------------------------->\n");

        return scanner.next().charAt(0);

    }

    private void register() {
    }

    private void login() {
    }
}
