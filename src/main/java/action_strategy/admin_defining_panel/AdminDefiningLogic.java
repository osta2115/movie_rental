package action_strategy.admin_defining_panel;

import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class AdminDefiningLogic {

    public Strategy definePermission(boolean isAdmin) {
        //TODO Logika pytająca o pole admin w bazie
        if (isAdmin) {
            return new AdminDefiningContext().operation(StrategyPicker.OPTION_1);
        }
        return new AdminDefiningContext().operation(StrategyPicker.OPTION_2);
    }
}
