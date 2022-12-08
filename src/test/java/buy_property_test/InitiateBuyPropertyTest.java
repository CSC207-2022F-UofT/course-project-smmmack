package buy_property_test;

import usecase_advance.AdvanceInputData;
import usecase_initiatebuyproperty.*;
import entities_main.Campaign;
import entities_main.CampaignAccess;
import entities_main.DefaultCampaignFactory;
import entities_main.Player;
import entities_tiles.PropertyTile;
import entities_tiles.Tile;
import viewmodel.InputMapDictionary;
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
        this.initiateBuyPropertyOutputBoundary = new InitiateBuyPropertyPresenter();
        this.initiateBuyPropertyInputBoundary = new InitiateBuyPropertyInteractor(initiateBuyPropertyOutputBoundary,
                campaignAccess);
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
