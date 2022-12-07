import AdvanceUseCase.*;
import MainEntities.CampaignAccess;
import MainEntities.Campaign;
import MainEntities.DefaultCampaignFactory;
import MainEntities.Player;
import ViewModel.InputMapDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdvanceTest {

    InputMapDictionary inputMapDict;
    CampaignAccess defCampaignAccess;

    AdvanceOutputBoundary advanceOutputBoundary;

    AdvanceInputBoundary advanceInputBoundary;

    public AdvanceTest() {
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
        this.advanceOutputBoundary = new AdvanceTestPresenter();
        this.advanceInputBoundary = new AdvanceInteractor(advanceOutputBoundary, defCampaignAccess,
                inputMapDict);
    }

    /**
     * Tests advancing a player 6 tiles forward, without passing the start.
     * @throws Exception if tile does not exist.
     */
    @Test
    public void Advance6TilesNoStart() throws Exception {

        // Initialize Advance input data.
        AdvanceInputData advanceInput = new AdvanceInputData(6);

        // Player #0's turn:
        advanceInputBoundary.performAction(advanceInput);
        int player0Location= defCampaignAccess.getCampaign().getCurrentPlayer().getLocation();
        Assertions.assertEquals(6, player0Location);
    }

    /**
     * Tests advancing a player 7 tiles forward, while passing the start.
     * @throws Exception if tile does not exist.
     */
    @Test
    public void Advance7TilesPassStart() throws Exception {

        // Initialize Advance input data.
        AdvanceInputData advanceInput = new AdvanceInputData(6);

        // Player #0's turn:
        Player player0 = defCampaignAccess.getCampaign().getCurrentPlayer();
        player0.setLocation(30);

        // Since there are 32 tiles, the player should pass start and end up on tile 4
        advanceInputBoundary.performAction(advanceInput);
        Assertions.assertEquals(4, player0.getLocation());
    }

    /**
     * Tests if advancing a player past start increases the player's money.
     * @throws Exception if tile does not exist.
     */
    @Test
    public void AdvanceStartIncreaseMoney() throws Exception {

        // Initialize Advance input data.
        AdvanceInputData advanceInput = new AdvanceInputData(6);

        // Player #0's turn:
        Player player0 = defCampaignAccess.getCampaign().getCurrentPlayer();
        player0.setLocation(30);

        // Since the player gets $1000 cash at the beginning, the player should end up with $1200 after the advance.
        advanceInputBoundary.performAction(advanceInput);
        Assertions.assertEquals(1200, player0.getCash());
    }

}
