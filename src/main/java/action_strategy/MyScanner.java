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

    public static boolean yesOrNo () {
        scanner = new Scanner(System.in);
        try {
            Character result = scanner.nextLine().charAt(0);
            if (result.equals('y') || result.equals('Y')){
                return true;
            } else if (result.equals('n') || result.equals('N')){
                return false;
            }else {
                System.out.println("Wrong answer. Y/N expected. Try again: ");
                return yesOrNo();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input type. Number expected. Try again: ");
            return yesOrNo();
        }
    }

    public static void pressAnyKeyToContiunue () {
        System.out.print("\nPress any key to continue.");
        scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}

