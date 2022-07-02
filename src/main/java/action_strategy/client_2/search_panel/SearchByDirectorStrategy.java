package action_strategy.client_2.search_panel;

import action_strategy.Strategy;

public class SearchByDirectorStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("search by director method");
        new SearchPanelLogic().startAdminUserManagementPanel();
    }
}
