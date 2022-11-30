package tradeUseCase;

public class tradePresenter implements tradeOutputBoundary {
    @Override
    public void create(tradeOutputData outputData){
        String tradeMessage = outputData.getTradeMessage();
        // Update viewmodel to display the trade message after Max's pull request is pushed.
    }

}
