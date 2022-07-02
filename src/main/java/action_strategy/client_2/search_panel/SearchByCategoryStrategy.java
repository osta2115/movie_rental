package action_strategy.client_2.search_panel;

import action_strategy.Strategy;

public class SearchByCategoryStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("search by category method");
        new SearchPanelLogic().startAdminUserManagementPanel();
    }
}
