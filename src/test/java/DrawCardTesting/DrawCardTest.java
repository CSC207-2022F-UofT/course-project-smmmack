package DrawCardTesting;

import Cards.Card;
import Cards.GainCashCard;
import DrawCardUseCase.DrawCardInputBoundary;
import DrawCardUseCase.DrawCardInputData;
import DrawCardUseCase.DrawCardInteractor;
import DrawCardUseCase.DrawCardOutputBoundary;
import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.DefaultCampaignFactory;
import MainEntities.Player;
import ViewModel.InputMapDictionary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class DrawCardTest {

    InputMapDictionary inputMapDict;
    CampaignAccess defCampaignAccess;

    DrawCardOutputBoundary drawCardOutputBoundary;
    DrawCardInputBoundary drawCardInputBoundary;

    public DrawCardTest() {
        inputMapDict = new InputMapDictionary();
        resetDefaultCampaign();
    }

    @BeforeEach
    public void resetDefaultCampaign() {
        DefaultCampaignFactory defCampaignFactory = new DefaultCampaignFactory(2);
        Campaign defCampaign = defCampaignFactory.create();
        this.defCampaignAccess = new CampaignAccess();
        this.defCampaignAccess.setCampaign(defCampaign);
        this.drawCardOutputBoundary = new DrawCardTestPresenter();
        this.drawCardInputBoundary = new DrawCardInteractor(drawCardOutputBoundary, defCampaignAccess);

    }

    @Test
    public void DrawCardGainCash() throws Exception {
        DrawCardInputData drawCardInputData = new DrawCardInputData("Community");

        Card drawnCard = defCampaignAccess.getCampaign().drawCardFromDeck("Community");
        int drawnCardAmt = ((GainCashCard)drawnCard).getAmount();
        Player player = defCampaignAccess.getCampaign().getCurrentPlayer();
        int prePlayer0Cash = player.getCash();

        drawCardInputBoundary.performAction(drawCardInputData, "Community");
        int postPlayer0Cash = player.getCash();
        Assertions.assertEquals(prePlayer0Cash + drawnCardAmt, postPlayer0Cash);
    }

    @Test
    public void DrawCardLoseCashSuccess() throws Exception {

    }

    @Test
    public void DrawCardLoseCashFail() throws Exception {

    }

    @Test
    public void DrawCardWrongInput() throws Exception {

    }
}
