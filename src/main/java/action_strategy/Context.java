package action_strategy;

public interface Context {
    Strategy operation(StrategyPicker strategyPicker);
}
