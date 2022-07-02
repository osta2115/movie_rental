package action_strategy;

import action_strategy.Strategy;

public class ExitProgramStrategy implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("Come back soon !");
        System.exit(3);
    }
}
