package action_strategy;

import java.util.Scanner;

public enum StrategyPicker {
    OPTION_1(1),
    OPTION_2(2),
    OPTION_3(3),
    OPTION_4(4),
    OPTION_5(5),
    OPTION_6(6),
    OPTION_7(7),
    OPTION_8(8),
    OPTION_9(9);

    private int intValue;

    StrategyPicker(int option) {

    }

    public int getOption() {
        return intValue;
    }
    public static StrategyPicker getOptionFromScanner(){
        System.out.println("Input required:");
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        int intInput = (int) input;
        System.out.println(input);
        for (StrategyPicker v : StrategyPicker.values()) {
            System.out.println(v.getOption());
            if (v.getOption() == intInput){
                return v;
            }
        }
        System.out.println("Incorrect input. Try again:");
        return StrategyPicker.getOptionFromScanner();
    }
}
