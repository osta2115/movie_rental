package action_strategy.client_2.change_details;

import action_strategy.Strategy;

public class ChangeEmailStrategy implements Strategy {
    @Override
    public void algorithm() {

        //TODO
        System.out.println("email change method");
        new ChangeDetailsPanelLogic().startChangeDetailsPanelPanel();
    }
}
