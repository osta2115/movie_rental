package action_strategy.client_2.search_panel;

import action_strategy.Strategy;

public class SearchByPegiCategoryStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("search by PEGI category method");
        new SearchPanelLogic().startAdminUserManagementPanel();
    }
}
