package DrawCard;

import Cards.Card;
import MainEntities.Deck;
import MainEntities.Player;

public class DrawCardInputData {
    // boolean confirm;
    private String playerName;
    private Deck deckType;

//    public DrawCardInputData(boolean confirm) {
//        this.confirm = true;
//    }
//    public boolean isConfirm() {return confirm;}

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

    //setters]]
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setDeckType(Deck deckType) {this.deckType = deckType; }
}
