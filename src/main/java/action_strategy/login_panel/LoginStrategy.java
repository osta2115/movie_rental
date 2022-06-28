package action_strategy.login_panel;

import action_strategy.Strategy;
import action_strategy.admin_defining.AdminDefiningLogic;

public class LoginStrategy implements Strategy {

    @Override
    public void algorithm() {
        // TODO login method
        System.out.println("Login method //not yet implemented//");
        // login passed
        boolean temporaryIsAdmin = true;
        new AdminDefiningLogic().definePermission(temporaryIsAdmin);
    }

}
