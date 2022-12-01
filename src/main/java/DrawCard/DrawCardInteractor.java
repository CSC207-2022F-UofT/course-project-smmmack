package DrawCard;

import Cards.Card;
import Cards.GainCashCard;
import Cards.LoseCashCard;
import MainEntities.Deck;
import MainEntities.Player;

public class DrawCardInteractor implements DrawCardInputBoundary {

    final DrawCardOutputBoundary output;
    final Player player;
    Card drawnCard;

    public DrawCardInteractor(DrawCardOutputBoundary output, Player player, Card card) {
        this.output = output;
        this.player = player;
        this.drawnCard = card;
    }

    /**
     * @param deckType The type of Deck that the player has to draw on.
     * @return An integer message informing the player about the card that they drew. There are 2 types of messages
     *         indicated as 1 or 2. If the message equals to 1, then the card they have drawn is a GainCashCard.
     *         If the message equals to 2, then the card they have drawn is a LoseCashCard.
     *         At the end, if the player has insufficient funds in their account after the card is preformed,
     *         then a message is shown that the player has become bankrupt.
     */

    public int performDrawCard(Deck deckType) {
        drawnCard = deckType.drawCard();
        int message = 0;

        if (drawnCard instanceof GainCashCard) {
            player.gainCash(((GainCashCard) drawnCard).getAmount());
            message = 1;
        } else if (drawnCard instanceof LoseCashCard) {
            player.gainCash(((LoseCashCard) drawnCard).getAmount());
            message = 2;
        }
        return message;
    }


    @Override
    public void performAction(DrawCardInputData drawCardInput, Deck deckType) throws Exception {
        int message = performDrawCard(deckType);
        DrawCardOutputData outputMessage;
        if (player.getCash() > 0) {
            if (message == 1) {
                outputMessage = new DrawCardOutputData("You gained:" + ((GainCashCard) drawnCard).getAmount() + ":)");
            } else { //(drawnCard instanceof LoseCashCard)
                outputMessage = new DrawCardOutputData("You lost:" + ((LoseCashCard) drawnCard).getAmount() + ":(");
            }
        } else {
            outputMessage = new DrawCardOutputData("You have insufficient funds. You are out of the game.");
        }
        output.performAction(outputMessage);
    }
}