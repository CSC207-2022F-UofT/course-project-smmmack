package DrawCard;

//add the imports I need from entities and or the other classes

import Cards.Card;
import Cards.GainCashCard;
import Cards.LoseCashCard;
import MainEntities.Deck;
import MainEntities.Player;

public class DrawCardInteractor implements DrawCardInputBoundary {

    final DrawCardOutputBoundary output;
    Player player;
    Card drawnCard;

    public DrawCardInteractor(DrawCardOutputBoundary output, Player player) {
        this.output = output;
        this.player = player;
    }

    public void performDrawCard(Deck deckType) throws Exception {
        drawnCard = deckType.drawCard();

        if (drawnCard instanceof GainCashCard) {
            player.gainCash(((GainCashCard) drawnCard).getAmount());
        } else if (drawnCard instanceof LoseCashCard) {
            player.gainCash(((LoseCashCard) drawnCard).getAmount());
        } else {
            throw new Exception("Not a gain or lose cash card");
        }
    }

    @Override
    public DrawCardOutputData create(DrawCardInputData drawCardInput) throws Exception {
        if (player.getCash() > 0) {
            if (drawnCard instanceof GainCashCard) {
                return output.prepareSuccessView("You gained:" + ((GainCashCard) drawnCard).getAmount() + ":)");
            } else { //(drawnCard instanceof LoseCashCard)
                return output.prepareSuccessView("You lost:" + ((LoseCashCard) drawnCard).getAmount() + ":(");
            }
        } else {
            return output.prepareFailureView("You have insufficient funds. You are out of the game.");
        }
    }
}
