package start_campaign_tests;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.DefaultCampaignFactory;
import MainEntities.Player;
import Properties.NormalProperty;
import StartCampaignUseCase.StartCampaignInputData;
import StartCampaignUseCase.StartCampaignInteractor;
import StartDefCampUseCase.StartDefCampInputData;
import StartDefCampUseCase.StartDefCampInteractor;
import Tiles.PropertyTile;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StartCampaignTests {

    @Test
    public void StartDefaultCampaignTest() {
        int expectedPlayerNum = 5;
        int expectedPlayerCash = 1000;
        int expectedDeckSize = 5;
        int expectedBoardSize = 32;
        StartDefCampInteractor interactor = new StartDefCampInteractor();
        CampaignAccess campaignAccess = new CampaignAccess();
        interactor.setCampaignAccess(campaignAccess);
        interactor.setOutputBoundary(outputData -> System.out.println(outputData.getMessage()));
        interactor.setStartCampaignInputBoundary(inputData -> System.out.println("next use case called"));

        StartDefCampInputData inputData = new StartDefCampInputData(expectedPlayerNum);
        interactor.performAction(inputData);
        Campaign campaign = campaignAccess.getCampaign();
        int actualPlayerNum = campaign.getPlayerNumber();
        Assertions.assertEquals(actualPlayerNum, expectedPlayerNum);
        for (int i = 0; i < expectedPlayerNum; i++) {
            Player player = campaign.getPlayerAt(i);
            Assertions.assertEquals(getExpectedPlayerName(i), player.getName());
            Assertions.assertEquals(expectedPlayerCash, player.getCash());
        }
        int cChestDeckSize = campaign.getDeck("community chest").getSize();
        Assertions.assertEquals(expectedDeckSize, cChestDeckSize);
        int chanceDeckSize = campaign.getDeck("chance").getSize();
        Assertions.assertEquals(expectedDeckSize, chanceDeckSize);
        int boardSize = campaign.getBoardSize();
        Assertions.assertEquals(expectedBoardSize, boardSize);
    }

    private String getExpectedPlayerName(int playerIndex) {
        return "p" + (playerIndex + 1);
    }

    @Test
    public void StartCampaignTest() {
        int expectedCash = 1453;
        int expectedHouselevel = 4;
        StartCampaignInteractor interactor = new StartCampaignInteractor();
        CampaignAccess campaignAccess = new CampaignAccess();
        Campaign campaign = new DefaultCampaignFactory(3).create();
        campaign.getPlayerAt(2).setCash(expectedCash);
        NormalProperty property = (NormalProperty) ((PropertyTile)campaign.getTileAt(1)).getProperty();
        property.setHouseLevel(expectedHouselevel);
        campaignAccess.setCampaign(campaign);
        interactor.setCampaignAccess(campaignAccess);
        interactor.setOutputBoundary(outputData -> {
            int actualCash = outputData.getPlayerCashes().get(2);
            Assertions.assertEquals(expectedCash, actualCash);
            int actualHouseLevel = outputData.getHouseLevels()[1];
            Assertions.assertEquals(expectedHouselevel, actualHouseLevel);
        });
        StartCampaignInputData inputData = new StartCampaignInputData("test campaign");
        interactor.performAction(inputData);
    }
}
