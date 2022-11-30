package Trade;
import java.io.IOException;

public interface TradeOutputBoundary {
    /**
     * Displays the trade menu.
     * @param outputData
     */
    void create(TradeOutputData outputData) throws IOException;

}