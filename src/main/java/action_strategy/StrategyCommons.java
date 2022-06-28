package action_strategy;

public class StrategyCommons {
    private static final StrategyCommons INSTANCE = new StrategyCommons();

    private StrategyCommons() {
    }

    public static StrategyCommons getInstance() {
        return INSTANCE;
    }

    public static void exitShop() {
        System.out.println("Come back soon !");
        System.exit(3);
    }

}