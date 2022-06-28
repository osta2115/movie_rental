package action_strategy.admin_2.manage_users;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ManageUsersContext implements Context {
    @Override
    public Strategy operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1:
                return new UserAddStrategy();
            case OPTION_2:
                return new UserRemoveStrategy();
            case OPTION_3:
                return new UserToggleAdminStrategy();
            case OPTION_4:
                return new UserModifyStrategy();
            case OPTION_5:
                return new ReturnToAdminPanelStrategy();
            default: {
                log.info("Wrong - enter command again");
                return operation(StrategyPicker.getOptionFromScanner());
            }
        }
    }
}
