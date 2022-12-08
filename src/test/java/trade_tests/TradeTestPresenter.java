package trade_tests;

import tradeUseCase.tradeOutputBoundary;
import tradeUseCase.tradeOutputData;

/**
 * Presenter class for AdvanceTest so that the View will not need to be updated each test call.
 */
public class TradeTestPresenter implements tradeOutputBoundary {

    @Override
    public void performAction(tradeOutputData outputData){
        // Void method for advance tests.
    }
}
