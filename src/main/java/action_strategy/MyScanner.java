package action_strategy;

import action_strategy.login_panel.LoginLogic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    private static final MyScanner INSTANCE = new MyScanner();

    private MyScanner() {
    }

    public static MyScanner getInstance() {
        return INSTANCE;
    }

    static Scanner scanner ;

    public static String getText() {
        scanner = new Scanner(System.in);
        try {
            String result = scanner.nextLine();
            return result;
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input type. Text expected. Try again: ");
            return getText();
        }
    }

    public static int getInt() {
        scanner = new Scanner(System.in);
        try {
            int result = scanner.nextInt();
            return result;
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input type. Number expected. Try again: ");
            return getInt();
        }
    }
}

