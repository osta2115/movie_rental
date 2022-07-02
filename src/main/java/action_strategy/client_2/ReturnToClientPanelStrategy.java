package action_strategy.client_2;

import action_strategy.Strategy;
import action_strategy.client_panel.ClientPanelLogic;

public class ReturnToClientPanelStrategy implements Strategy {
    @Override
    public void algorithm() {
        ClientPanelLogic.getInstance().startClientPanel();
    }
}
