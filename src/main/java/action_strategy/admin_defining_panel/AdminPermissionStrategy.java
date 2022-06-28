package action_strategy.admin_defining_panel;

import action_strategy.Strategy;
import action_strategy.admin_panel.AdminPanelLogic;

public class AdminPermissionStrategy implements Strategy {
    @Override
    public void algorithm() {
        new AdminPanelLogic().startAdminPanel();
    }
}
