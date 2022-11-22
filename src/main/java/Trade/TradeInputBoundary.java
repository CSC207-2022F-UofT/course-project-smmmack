package Trade;

public interface TradeInputBoundary {
    default TradeOutputData create(TradeInputData input) throws Exception {
        return null;
    }
}