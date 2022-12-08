package DrawCard;

public class DrawCardInputData {

    private String deckType;

    /**
     *
     * @param deckType The string type of Deck that the player has to draw on.
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
