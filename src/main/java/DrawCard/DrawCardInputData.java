package DrawCard;

import MainEntities.Deck;

public class DrawCardInputData {
    // boolean confirm;
    private String playerName;

    /**
     *
     * @param playerName the name of the player who has to draw a Card.
     */
    private Deck deckType;

    /**
     *
     * @param deckType The type of Deck that the player has to draw on.
     */

    public DrawCardInputData(String playerName, Deck deckType){
        this.playerName = playerName;
        this.deckType = deckType;
    }

    //getters
    public String getPlayerName() {
        return playerName;
    }
    public Deck getDeckType() {
        return deckType;
    }

    //setters
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setDeckType(Deck deckType) {this.deckType = deckType; }
}
