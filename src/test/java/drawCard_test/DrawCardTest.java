package drawCard_test;

import DrawCardUseCase.*;
import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.DefaultCampaignFactory;
import ViewModel.InputMapDictionary;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DrawCardTest {

    InputMapDictionary inputMapDict;
    CampaignAccess defCampaignAccess;
    DrawCardOutputBoundary drawCardOutputBoundary;
    DrawCardInputBoundary drawCardInputBoundary;

    public DrawCardTest() {
        inputMapDict = new InputMapDictionary();
        resetDefaultCampaign();
    }

    @Before
    public void resetDefaultCampaign() {
        DefaultCampaignFactory defCampaignFactory = new DefaultCampaignFactory(2);
        Campaign defCampaign = defCampaignFactory.create();
        this.defCampaignAccess = new CampaignAccess();
        this.defCampaignAccess.setCampaign(defCampaign);
        this.drawCardOutputBoundary = new DrawCardTestPresenter();
        this.drawCardInputBoundary = new DrawCardInteractor(drawCardOutputBoundary, defCampaignAccess);
    }

    /**
     * Tests draw card when drawing a chance card that is a GainCashCard.
     * @throws Exception if the player becomes bankrupt
     */
    @Test
    public void DrawCardGainCash() throws Exception {
        String deckType = "chance";
        DrawCardInputData drawCardInputData = new DrawCardInputData(deckType);
        drawCardInputBoundary.performAction(drawCardInputData, deckType);
        int player0cash = defCampaignAccess.getCampaign().getCurrentPlayer().getCash();
        Assertions.assertEquals(1200, player0cash);
    }

    /**
     * Tests draw card when drawing a community chest card that is a LoseCashCard.
     * @throws Exception if the player becomes bankrupt
     */
    @Test
    public void DrawCardLoseCash() throws Exception {
        String deckType = "community chest";
        DrawCardInputData drawCardInputData = new DrawCardInputData(deckType);
        drawCardInputBoundary.performAction(drawCardInputData, deckType);
        int player0cash = defCampaignAccess.getCampaign().getCurrentPlayer().getCash();
        Assertions.assertEquals(850, player0cash);
    }
}
