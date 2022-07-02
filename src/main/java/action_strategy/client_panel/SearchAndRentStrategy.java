package action_strategy.client_panel;

import action_strategy.Strategy;
import action_strategy.client_2.search_panel.SearchPanelLogic;

public class SearchAndRentStrategy implements Strategy {
    @Override
    public void algorithm() {
        new SearchPanelLogic().startAdminUserManagementPanel();
    }
}
