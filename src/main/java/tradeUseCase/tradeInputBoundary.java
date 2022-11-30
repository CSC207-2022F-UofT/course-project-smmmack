package tradeUseCase;

public interface tradeInputBoundary {

    /**
     * Displays the trade menu.
     * @param input
     */
    void preformAction(tradeInputData input) throws Exception;
}