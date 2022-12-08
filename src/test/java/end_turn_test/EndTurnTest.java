package end_turn_test;

import usecase_endturn.EndTurnInputData;
import usecase_endturn.EndTurnInteractor;
import entities_main.Campaign;
import entities_main.CampaignAccess;
import entities_main.DefaultCampaignFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EndTurnTest {
    @Test
    public void testEndTurn() {
        int expectedRoundCount = 8;
        int expectedCurrPlayerIndex = 0;
        String expectedMessage = "Now it's player p1's turn. (Round count: 8)";
        EndTurnInteractor interactor = new EndTurnInteractor();
        CampaignAccess campaignAccess = new CampaignAccess();
        Campaign campaign = new DefaultCampaignFactory(6).create();
        campaign.setRoundCount(expectedRoundCount - 1);
        campaign.setCurrPlayerIndex(5);
        campaignAccess.setCampaign(campaign);
        interactor.setCampaignAccess(campaignAccess);
        interactor.setOutputBoundary(outputData -> Assertions.assertEquals(expectedMessage, outputData.getMessage()));

        EndTurnInputData inputData = new EndTurnInputData();
        interactor.performAction(inputData);

        int actualRoundCount = campaign.getRoundCount();
        Assertions.assertEquals(expectedRoundCount, actualRoundCount);
        int actualCurrPlayerIndex = campaign.getCurrPlayerIndex();
        Assertions.assertEquals(expectedCurrPlayerIndex, actualCurrPlayerIndex);
    }
}
