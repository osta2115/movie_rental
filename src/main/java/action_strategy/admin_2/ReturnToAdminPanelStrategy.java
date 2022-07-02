package action_strategy.admin_2;

import action_strategy.Strategy;
import action_strategy.admin_panel.AdminPanelLogic;

public class ReturnToAdminPanelStrategy implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("Returning");
        AdminPanelLogic.getInstance().startAdminPanel();
    }
}
