package action_strategy.admin_defining;

import action_strategy.Strategy;
import action_strategy.admin_panel.AdminPanelLogic;

public class AdminPermissionStrategy implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("starting panel");
        AdminPanelLogic.getInstance().startAdminPanel();
    }
}
