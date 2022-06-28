package action_strategy.admin_defining;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class AdminDefiningLogic {

    public void definePermission(boolean isAdmin) {
        //TODO Logika pytająca o pole admin w bazie
        Context adminDefiningContext = new AdminDefiningContext();
        Strategy operation;
        if (isAdmin) {
             operation = adminDefiningContext.operation(StrategyPicker.OPTION_1);
        }else operation =adminDefiningContext.operation(StrategyPicker.OPTION_2);
        operation.algorithm();
    }
}
