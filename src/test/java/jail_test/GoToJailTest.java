package jail_test;

import usecase_gotojail.*;
import entities_main.CampaignAccess;
import entities_main.Campaign;
import entities_main.DefaultCampaignFactory;
import viewmodel.InputMapDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoToJailTest {

    InputMapDictionary inputMapDict;
    CampaignAccess defCampaignAccess;

    GoToJailOutputBoundary goToJailOutputBoundary;

    GoToJailInputBoundary goToJailInputBoundary;

    public GoToJailTest() {
        inputMapDict = new InputMapDictionary();
        resetDefaultCampaign();
    }

    @BeforeEach
    public void resetDefaultCampaign() {
        // New Default Campaign
        DefaultCampaignFactory defaultCampaignFactory = new DefaultCampaignFactory(4);
        // Makes a new campaign with a game board with 32 tiles and 4 players.
        Campaign defCampaign = defaultCampaignFactory.create();
        this.defCampaignAccess = new CampaignAccess();
        this.defCampaignAccess.setCampaign(defCampaign);
        this.goToJailOutputBoundary = new GoToJailPresenter();
        this.goToJailInputBoundary = new GoToJailInteractor(goToJailOutputBoundary, defCampaignAccess,
                inputMapDict);
    }

    /**
     * Tests advancing a player 6 tiles forward, without passing the start.
     * @throws Exception if tile does not exist.
     */
    @Test
    public void PlayerJailTern() throws Exception {
        int playerIndex = defCampaignAccess.getCampaign().getCurrPlayerIndex();

        // Initialize Advance input data.
        GoToJailInputData goToJailInput = new GoToJailInputData(true, playerIndex, 24);

        // Player #0's turn:
        goToJailInputBoundary.performAction(goToJailInput);
        int JailTern= defCampaignAccess.getCampaign().getCurrentPlayer().getJailTurn();
        Assertions.assertEquals( JailTern, 1);
    }

    /**
     * Tests advancing a player 7 tiles forward, while passing the start.
     * @throws Exception if tile does not exist.
     */
    @Test
    public void PlayerJailTile() throws Exception {
        int playerIndex = defCampaignAccess.getCampaign().getCurrPlayerIndex();

        // Initialize Advance input data.
        GoToJailInputData goToJailInput = new GoToJailInputData(true, playerIndex, 24);

        // Player #0's turn:
        goToJailInputBoundary.performAction(goToJailInput);
        int JailTile= defCampaignAccess.getCampaign().getCurrentPlayer().getLocation();
        Assertions.assertEquals( JailTile, 24);
    }

    /**
     * Tests if advancing a player past start increases the player's money.
     * @throws Exception if tile does not exist.
     */
    @Test
    public void Player() throws Exception {
        int playerIndex = defCampaignAccess.getCampaign().getCurrPlayerIndex();

        // Initialize Advance input data.
        GoToJailInputData goToJailInput = new GoToJailInputData(true, playerIndex, 24);

        // Player #0's turn:
        goToJailInputBoundary.performAction(goToJailInput);
        int pi= defCampaignAccess.getCampaign().getCurrPlayerIndex();
        Assertions.assertEquals( pi, playerIndex);
    }

}
