package action_strategy.client_2.change_details;

import action_strategy.Strategy;

public class ChangePhoneStrategy implements Strategy {
    @Override
    public void algorithm() {

        //TODO
        System.out.println("phone change method");
        new ChangeDetailsPanelLogic().startChangeDetailsPanelPanel();
    }
}
