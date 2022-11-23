package Trade;

public class TradePresenter implements TradeOutputBoundary{
    @Override
    public TradeOutputData prepareSuccessView(Boolean results) {
        return null;
    }

    @Override
    public TradeOutputData prepareSuccessView(boolean message) {
        return null;
    }
    public TradeOutputData prepareFailureView(String message){
        return null;
    }

}
