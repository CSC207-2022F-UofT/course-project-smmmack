package Trade;

public interface TradeInputBoundary {
    //change to private`
    default TradeOutputData create(TradeInputData input) throws Exception {
        return null;
    }
}