package Trade;

public class TradePresenter implements TradeOutputBoundary{
    @Override
    public void create(TradeOutputData outputData){
        String tradeMessage = outputData.getTradeMessage();
        // Update viewmodel to display the trade message after Max's pull request is pushed.
    }

}
