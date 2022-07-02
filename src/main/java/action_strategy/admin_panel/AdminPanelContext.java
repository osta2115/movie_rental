package action_strategy.admin_panel;

import action_strategy.Context;
import action_strategy.LogOutStrategy;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminPanelContext implements Context {
    @Override
    public Strategy operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1:
                return new UserOperationsStrategy();
            case OPTION_2:
                return new ProductOperationsStrategy();
            case OPTION_3:
                return new BranchesOperationsStrategy();
            case OPTION_4:
                return new LogOutStrategy();
            default: {
                log.info("Wrong - enter command again");
                return operation(StrategyPicker.getOptionFromScanner());
            }
        }
    }
}
