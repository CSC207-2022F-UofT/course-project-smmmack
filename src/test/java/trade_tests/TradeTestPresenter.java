package trade_tests;

import usecase_trade.TradeOutputBoundary;
import usecase_trade.TradeOutputData;

/**
 * Presenter class for AdvanceTest so that the View will not need to be updated each test call.
 */
public class TradeTestPresenter implements TradeOutputBoundary {

    @Override
    public void performAction(TradeOutputData outputData){
        // Void method for advance tests.
    }
}
