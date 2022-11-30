package tradeUseCase;
import java.io.IOException;

public interface tradeOutputBoundary {
    /**
     * Displays the trade menu.
     * @param outputData
     */
    void create(tradeOutputData outputData) throws IOException;

}