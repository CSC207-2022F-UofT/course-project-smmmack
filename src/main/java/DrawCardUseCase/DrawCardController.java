package DrawCardUseCase;
// Need to change package name

/**
 * The DrawCardController takes in DrawCardInputBoundary that can be used by the DrawCardInteractor
 */
public class DrawCardController {
    private DrawCardInputBoundary inputBoundary;

    public DrawCardController(DrawCardInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     *
     * @param deckType The string type of Deck that the player has to draw on.
     */
    void performAction(String deckType) throws Exception {
        DrawCardInputData drawCardInputData = new DrawCardInputData(deckType);
        inputBoundary.performAction(drawCardInputData, deckType);
    }

    // getters
    public DrawCardInputBoundary getDrawCardInput(){
        return inputBoundary;
    }

    // setters
    public void setDrawCardInput(DrawCardInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }
}
