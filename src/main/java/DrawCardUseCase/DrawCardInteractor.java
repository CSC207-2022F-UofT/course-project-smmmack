package DrawCardUseCase;
// Need to change pckage name

import Cards.Card;
import Cards.GainCashCard;
import Cards.LoseCashCard;
import MainEntities.CampaignAccess;
import MainEntities.Player;

public class DrawCardInteractor implements DrawCardInputBoundary {

    private DrawCardOutputBoundary drawCardOutputBoundary;
    private CampaignAccess campaignAccess;

    // Empty Constructor
    public DrawCardInteractor() {
    }

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
     * This method will use the getDrawnCard method to update the Player's funds and display a method including the
     * drawnCard's name and description, which will include how much money is lost or gained.
     */

    @Override
    public void performAction(DrawCardInputData drawCardInput, String deckType) throws Exception {
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        DrawCardOutputData outputMessage;
        Card drawnCard = getDrawnCard(deckType);
        if (drawnCard instanceof GainCashCard) {
            player.gainCash(((GainCashCard) drawnCard).getAmount());
            outputMessage = new DrawCardOutputData("You drew the card:" + drawnCard.getName() + ":" +
                    drawnCard.getDescription(), true, campaignAccess.getCampaign().getCurrPlayerIndex(),
                    ((GainCashCard) drawnCard).getAmount(), true);
        } else if (drawnCard instanceof LoseCashCard) {
            player.loseCash(((LoseCashCard) drawnCard).getAmount());
            outputMessage = new DrawCardOutputData("You drew the card:" + drawnCard.getName() + ":" +
                    drawnCard.getDescription(),true, campaignAccess.getCampaign().getCurrPlayerIndex(),
                    ((LoseCashCard) drawnCard).getAmount(), false);
        }
        else {
            outputMessage = new DrawCardOutputData("Error: not valid", false, 0,
                    0, false);
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
