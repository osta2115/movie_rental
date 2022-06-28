package action_strategy;

/**
 * Universal methods used in many panels.
 */
public class StrategyCommons {
    private static final StrategyCommons INSTANCE = new StrategyCommons();

    private StrategyCommons() {
    }

    public static StrategyCommons getInstance() {
        return INSTANCE;
    }

}