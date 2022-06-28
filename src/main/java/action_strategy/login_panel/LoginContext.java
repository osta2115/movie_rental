package action_strategy.login_panel;

import action_strategy.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginContext implements Context {

    @Override
    public Strategy operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1:
                return new LoginStrategy();
            case OPTION_2:
                return new RegisterStrategy();
            case OPTION_3:
                return new ExitProgramStrategy();
            default: {
                log.info("Wrong - enter command again");
                return operation(StrategyPicker.getOptionFromScanner());
            }
        }
    }
}
