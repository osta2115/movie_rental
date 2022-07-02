package action_strategy.client_panel;

import action_strategy.Strategy;
import action_strategy.client_2.change_details.ChangeDetailsPanelLogic;

public class ChangeAccountDetailsStrategy implements Strategy {
    @Override
    public void algorithm() {
        new ChangeDetailsPanelLogic().startChangeDetailsPanelPanel();
    }
}
