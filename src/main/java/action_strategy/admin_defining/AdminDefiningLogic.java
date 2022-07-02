package action_strategy.admin_defining;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;
import action_strategy.login_panel.LoginLogic;

public class AdminDefiningLogic {
    private static final AdminDefiningLogic INSTANCE = new AdminDefiningLogic();

    private AdminDefiningLogic() {
    }

    public static AdminDefiningLogic getInstance() {
        return INSTANCE;
    }


    public void definePermission(boolean isAdmin) {
        //TODO Logika pytająca o pole admin w bazie
        Context adminDefiningContext = new AdminDefiningContext();
        Strategy operation;
        if (isAdmin) {
            operation = adminDefiningContext.operation(StrategyPicker.OPTION_1);
        } else operation = adminDefiningContext.operation(StrategyPicker.OPTION_2);
        operation.algorithm();
    }
}
