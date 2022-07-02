package action_strategy.client_panel;

import action_strategy.Context;
import action_strategy.LogOutStrategy;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientPanelContext implements Context {
    @Override
    public Strategy operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1:
                return new SearchAndRentStrategy();
            case OPTION_2:
                return new ChangeAccountDetailsStrategy();
            case OPTION_3:
                return new LogOutStrategy();
            default: {
                log.info("Wrong - enter command again");
                return operation(StrategyPicker.getOptionFromScanner());
            }
        }
    }
}
