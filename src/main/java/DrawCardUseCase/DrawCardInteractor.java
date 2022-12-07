package DrawCardUseCase;

import Cards.Card;
import Cards.GainCashCard;
import Cards.LoseCashCard;
import MainEntities.CampaignAccess;
import MainEntities.Player;

public class DrawCardInteractor implements DrawCardInputBoundary {

    private DrawCardOutputBoundary drawCardOutputBoundary;
    private CampaignAccess campaignAccess;

    public DrawCardInteractor(DrawCardOutputBoundary drawCardOutputBoundary, CampaignAccess campaignAccess) {
        this.drawCardOutputBoundary = drawCardOutputBoundary;
        this.campaignAccess = campaignAccess;
    }

    /**
     * @param deckType The String of the type of Deck that the player has to draw on.
     * @return The Card that is drawn from whichever type of deck that deckType is.
     */
    public Card getDrawnCard(String deckType) {
        return campaignAccess.getCampaign().drawCardFromDeck(deckType);
    }

    /**
     * @param deckType The String of the type of Deck that the player has to draw on.
     * @return An integer message informing the player about the card that they drew. There are 2 types of messages
     * indicated as 1 or 2. If the message equals to 1, then the card they have drawn is a GainCashCard.
     * If the message equals to 2, then the card they have drawn is a LoseCashCard.
     * At the end, if the player has insufficient funds in their account after the card is preformed,
     * then a message is shown that the player has become bankrupt.
     */
    public int performCard(String deckType, Player player) {
        Card drawnCard = getDrawnCard(deckType);
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
    public void performAction(DrawCardInputData drawCardInput, String deckType) throws Exception {
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        int message = performCard(deckType, player);
        Card drawnCard = getDrawnCard(deckType);
        DrawCardOutputData outputMessage;
        if (player.getCash() > 0) {
            if (message == 1) {
                outputMessage = new DrawCardOutputData("You gained:" + ((GainCashCard) drawnCard).getAmount()
                        + ":)", true, campaignAccess.getCampaign().getCurrPlayerIndex(),
                        ((GainCashCard) drawnCard).getAmount(), true);
            } else { //(drawnCard instanceof LoseCashCard)
                outputMessage = new DrawCardOutputData("You lost:" + ((LoseCashCard) drawnCard).getAmount()
                        + ":(", true, campaignAccess.getCampaign().getCurrPlayerIndex(),
                        ((LoseCashCard) drawnCard).getAmount(), false);
            }
        } else {
            outputMessage = new DrawCardOutputData("You have insufficient funds. You are out of the game."
                    , false, campaignAccess.getCampaign().getCurrPlayerIndex(), 0, false);
        }
        campaignAccess.getCampaign().getDeck(deckType).putCard(drawnCard);
        drawCardOutputBoundary.performAction(outputMessage, deckType);
    }

    //getters
    public DrawCardOutputBoundary getDrawCardOutputBoundary() {return drawCardOutputBoundary;}
    public CampaignAccess getCampaignAccess() {return campaignAccess;}

    //setters
    public void setDrawCardOutputBoundary(DrawCardOutputBoundary drawCardOutputBoundary) {
        this.drawCardOutputBoundary = drawCardOutputBoundary;
    }
    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }
}
