package DrawCard;

import Cards.Card;
import MainEntities.Deck;
import MainEntities.Player;

public class DrawCardInputData {
    // str name of player, str type of card
    boolean confirm;
    private String playerName;
    private String cardType;

    public DrawCardInputData(boolean confirm) {
        this.confirm = true;
    }
    public boolean isConfirm() {return confirm;}

    public DrawCardInputData(String playerName, String cardType){
        this.playerName = playerName;
        this.cardType = cardType;
    }

    //getters
    public String getPlayerName() {
        return playerName;
    }
    public String getCardType() {
        return cardType;
    }

    //setters]]
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
