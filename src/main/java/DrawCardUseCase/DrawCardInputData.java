package DrawCardUseCase;
// Need to change package name

public class DrawCardInputData {

    private String deckType;

    /**
     *
     * @param deckType The string type of Deck that the player has to draw on. This is given by the Advance Use Case.
     */

    public DrawCardInputData(String deckType) {
        this.deckType = deckType;
    }

    //getters
    public String getDeckType() {
        return deckType;
    }

    //setters
    public void setDeckType(String deckType) {this.deckType = deckType; }
}

