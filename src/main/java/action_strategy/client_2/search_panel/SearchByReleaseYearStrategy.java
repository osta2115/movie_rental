package action_strategy.client_2.search_panel;

import action_strategy.Strategy;

public class SearchByReleaseYearStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("search by release year method");
        new SearchPanelLogic().startAdminUserManagementPanel();
    }
}
