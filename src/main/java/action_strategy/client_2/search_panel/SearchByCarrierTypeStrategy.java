package action_strategy.client_2.search_panel;

import action_strategy.Strategy;

public class SearchByCarrierTypeStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("search by carrier type method");
        new SearchPanelLogic().startAdminUserManagementPanel();
    }
}
