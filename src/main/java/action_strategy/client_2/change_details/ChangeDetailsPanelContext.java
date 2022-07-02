package action_strategy.client_2.change_details;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;
import action_strategy.client_2.ReturnToClientPanelStrategy;
import action_strategy.client_2.search_panel.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChangeDetailsPanelContext implements Context {
    @Override
    public Strategy operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1:
                return new ChangePasswordStrategy();
            case OPTION_2:
                return new ChangeAddressStrategy();
            case OPTION_3:
                return new ChangeEmailStrategy();
            case OPTION_4:
                return new ChangePhoneStrategy();
            case OPTION_5:
                return new ReturnToClientPanelStrategy();
            default: {
                log.info("Wrong - enter command again");
                return operation(StrategyPicker.getOptionFromScanner());
            }
        }
    }
}
