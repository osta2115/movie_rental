package action_strategy;

import tables.Client;

/**
 * Universal methods used in many panels.
 */
public class StrategyCommons {
    private static final StrategyCommons INSTANCE = new StrategyCommons();

    private StrategyCommons() {
    }

    public static StrategyCommons getInstance() {
        return INSTANCE;
    }

    private Client loggedUser;

    Client setLoggedClient(Client client) {
        this.loggedUser = client;
        return client;
    }

    Client getClient() {
        if (loggedUser == null) {
            System.out.println("no user logged to system");
            return null;
        }
        else  return loggedUser;
    }

    boolean logoutUser () {
        loggedUser = null;
        return loggedUser == null;
    }

}