package usecase_drawcard;
// Need to change package name

public interface DrawCardInputBoundary {
    void performAction(DrawCardInputData drawCardInput, String deckType) throws Exception;
}