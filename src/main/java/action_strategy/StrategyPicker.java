package action_strategy;

import java.util.Optional;
import java.util.Scanner;

public enum StrategyPicker {
    OPTION_0,
    OPTION_1,
    OPTION_2,
    OPTION_3,
    OPTION_4,
    OPTION_5,
    OPTION_6,
    OPTION_7,
    OPTION_8,
    OPTION_9;

    public static StrategyPicker getTypeByOrdinal(int ordinal) {
        for (StrategyPicker t : StrategyPicker.values()) {
            if (t.ordinal() == ordinal) {
                return t;
            }
        }
        return null;
    }


    public static StrategyPicker getOptionFromScanner() {
        System.out.println("Input required:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Optional<StrategyPicker> strategyPicker = Optional.ofNullable(StrategyPicker.getTypeByOrdinal(input));

        if (strategyPicker.isEmpty()) {
            System.out.printf("Incorrect input. New ");
            return getOptionFromScanner();
        }

        return strategyPicker.get();
    }

}
