package action_strategy.login_panel;

import action_strategy.Strategy;

public class RegisterStrategy implements Strategy {
    @Override
    public void algorithm() {
            // TODO register method
            System.out.println("Register method //not yet implemented//");
            System.out.println("Please log in:");
            new LoginStrategy().algorithm();
    }
}
