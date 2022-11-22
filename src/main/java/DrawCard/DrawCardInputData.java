package DrawCard;

import Cards.Card;
import MainEntities.Deck;
import MainEntities.Player;

public class DrawCardInputData {
    // str name of player, str type of card
    boolean confirm;
    Player playerName;
    Deck cardDeck;

    public DrawCardInputData(boolean confirm) {
        this.confirm = true;
    }

    public boolean isConfirm() {return confirm;}

    public String getPlayerName(Player playerName) {
        return playerName.getName();
    }

    public Card getCard(Deck cardDeck) {
        return cardDeck.drawCard();
    }

    public String getCardType(Card drawnCard) {
        /* Want to draw card from the community chest deck or chance deck.
        Then we want to decide if it is a loose cash or gain cash card.
         */
        drawnCard =
    }
}
