package action_strategy.client_2.change_details;

import action_strategy.Strategy;

public class ChangePasswordStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("password change method");
        new ChangeDetailsPanelLogic().startChangeDetailsPanelPanel();
    }
}
