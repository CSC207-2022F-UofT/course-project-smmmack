package buy_property_test;

import AdvanceUseCase.AdvanceInputData;
import InitiateBuyPropertyUseCase.*;
import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.DefaultCampaignFactory;
import MainEntities.Player;
import Tiles.PropertyTile;
import Tiles.Tile;
import ViewModel.InputMapDictionary;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class InitiateBuyPropertyTest {

    InputMapDictionary inputMapDictionary;
    CampaignAccess campaignAccess;
    InitiateBuyPropertyOutputBoundary initiateBuyPropertyOutputBoundary;
    InitiateBuyPropertyInputBoundary initiateBuyPropertyInputBoundary;

    AdvanceInputData advanceInputData;

    public InitiateBuyPropertyTest() {
        inputMapDictionary = new InputMapDictionary();

    }

    @BeforeEach
    public void InitiateBuyPropertySetUp() {
        DefaultCampaignFactory defaultCampaignFactory = new DefaultCampaignFactory(4);
        Campaign defaultCampaign = defaultCampaignFactory.create();
        this.campaignAccess = new CampaignAccess();
        this.campaignAccess.setCampaign(defaultCampaign);
        this.initiateBuyPropertyInputBoundary = new InitiateBuyPropertyInteractor();
        this.initiateBuyPropertyOutputBoundary = new InitiateBuyPropertyPresenter();
    }

    /**
     * Tests whether the player is landed on a Property Tile.
     * @throws Exception If the tile is not found.
     */

    @Test
    public void testInitiateBuyPropertyCheckPropertyTile() throws Exception {
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        AdvanceInputData advanceInputData0 = new AdvanceInputData(6);
        Tile tileUnderPlayer = campaignAccess.getCampaign().getTileUnderPlayer(player);
        PropertyTile propertyTile = (PropertyTile) campaignAccess.getCampaign().getTileUnderPlayer(player);
        InitiateBuyPropertyInputData initiateBuyPropertyInputData =
                new InitiateBuyPropertyInputData(true);
        initiateBuyPropertyInputBoundary.performAction(initiateBuyPropertyInputData);

        assert tileUnderPlayer instanceof PropertyTile;
    }
}
