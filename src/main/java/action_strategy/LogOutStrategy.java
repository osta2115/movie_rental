package action_strategy;

import action_strategy.login_panel.LoginLogic;

public class LogOutStrategy implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("Logged out");
        StrategyCommons.getInstance().logoutUser();
        LoginLogic.getInstance().startLoginPanel();
    }
}
