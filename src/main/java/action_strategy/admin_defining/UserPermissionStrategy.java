package action_strategy.admin_defining;

import action_strategy.Strategy;
import action_strategy.client_panel.ClientPanelLogic;

public class UserPermissionStrategy implements Strategy {
    @Override
    public void algorithm() {
        //todo
        System.out.println("user");
        ClientPanelLogic.getInstance().startClientPanel();
    }
}
