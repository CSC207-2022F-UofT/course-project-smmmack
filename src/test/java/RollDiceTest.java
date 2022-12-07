import AdvanceUseCase.AdvanceInputBoundary;
import AdvanceUseCase.AdvanceInteractor;
import AdvanceUseCase.AdvanceOutputBoundary;
import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.DefaultCampaignFactory;
import MainEntities.Player;
import RollDiceUseCase.*;
import ViewModel.InputMapDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RollDiceTest {
    CampaignAccess defCampaignAccess;
    RollDiceOutputBoundary rollDiceOutputBoundary;
    RollDiceInputBoundary rollDiceInputBoundary;
    AdvanceInputBoundary advanceInputBoundary;
    AdvanceOutputBoundary advanceOutputBoundary;
    InputMapDictionary inputMapDict;

    public RollDiceTest(){

    }

    @BeforeEach
    public void resetDefaultCampaign() {
        // New Default Campaign
        DefaultCampaignFactory defaultCampaignFactory = new DefaultCampaignFactory(4);
        // Makes a new campaign with a game board with 32 tiles and 4 players.
        Campaign defCampaign = defaultCampaignFactory.create();
        this.defCampaignAccess = new CampaignAccess();
        this.defCampaignAccess.setCampaign(defCampaign);

        // Set up RollDice classes.
        this.advanceOutputBoundary = new AdvanceTestPresenter();
        this.advanceInputBoundary = new AdvanceInteractor(advanceOutputBoundary, defCampaignAccess,
                inputMapDict);
        this.rollDiceOutputBoundary = new RollDiceTestPresenter();
        this.rollDiceInputBoundary = new RollDiceInteractor(rollDiceOutputBoundary,defCampaignAccess,
                advanceInputBoundary);
    }

    /**
     * Checks if RollDice successfully calls the Advance Use Case if the user confirms roll by comparing
     * the player's position before and after a call to the Roll Dice interactor.
     * @throws Exception if the tile landed does not exist.
     */
    @Test
    public void RollDiceCallAdvanceTrue() throws Exception {
        Player player0 = defCampaignAccess.getCampaign().getCurrentPlayer();

        int beforeLocation = player0.getLocation();
        RollDiceInputData rollDiceInputData = new RollDiceInputData(true);
        rollDiceInputBoundary.performAction(rollDiceInputData);

        Assertions.assertNotEquals(beforeLocation, player0.getLocation());
    }

    /**
     * Checks if RollDice does not call the Advance Use Case if the user doesn't confirm roll by comparing
     * the player's position before and after a call to the Roll Dice interactor.
     * @throws Exception if the tile landed does not exist.
     */
    @Test
    public void RollDiceCallAdvanceFalse() throws Exception {
        Player player0 = defCampaignAccess.getCampaign().getCurrentPlayer();

        int beforeLocation = player0.getLocation();
        RollDiceInputData rollDiceInputData = new RollDiceInputData(false);
        rollDiceInputBoundary.performAction(rollDiceInputData);

        Assertions.assertEquals(beforeLocation, player0.getLocation());
    }

}
