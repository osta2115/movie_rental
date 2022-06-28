package action_strategy.admin_defining_panel;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;


public class AdminDefiningContext implements Context {
    @Override
    public Strategy operation(StrategyPicker strategyPicker) {
        if (strategyPicker == StrategyPicker.OPTION_1) {
            System.out.println("Logging as admin");
            return new AdminPermissionStrategy();
        }else {
            System.out.println("Logging as client");
            return new UserPermissionStrategy();
        }
    }
}
