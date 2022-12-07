package DrawCardUseCase;

public interface DrawCardInputBoundary {
    void performAction(DrawCardInputData drawCardInput, String deckType) throws Exception;
}