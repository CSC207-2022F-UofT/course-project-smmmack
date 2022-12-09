package trade_tests;
import entities_main.CampaignAccess;
import entities_main.Campaign;
import entities_main.DefaultCampaignFactory;
import entities_main.Player;
import entities_properties.NormalProperty;
import entities_properties.Property;
import viewmodel.InputMapDictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase_trade.*;

import java.util.ArrayList;
import java.util.List;

public class TradeAcceptTest {

    InputMapDictionary inputMapDict;
    CampaignAccess defCampaignAccess;

    TradeOutputBoundary tradeOutputBoundary;

    TradeInputBoundary tradeInputBoundary;

    public TradeAcceptTest() {
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
        this.tradeOutputBoundary = new TradeTestPresenter();
        this.tradeInputBoundary = new TradeInteractor(tradeOutputBoundary, defCampaignAccess);
    }

    /**
     * GIVES each player 2 properties, and 4000 dollars. Player 0 offers to trade 1 property for 2000 dollars and one player 1s properties.
     * Player 1 accepts the trade. Player 0's property is removed, and player 1's property is added.
     * Player 0's money is increased by 2000, and player 1's money is decreased by 2000.
     *
     * @throws Exception if tile does not exist.
     *                   Tests if the trade would work
     */
    @Test
    public void tradeAcceptPropertiesAndCash() throws Exception {
        // Initialize Advance input data.
        // first we give the playerst the properties and cash they need
        //List of Properties
        List<NormalProperty> testList = new ArrayList<NormalProperty>();
        // Add Normal Properties to the list
        Player player0 = defCampaignAccess.getCampaign().getPlayerAt(0);
        Player player1 = defCampaignAccess.getCampaign().getPlayerAt(1);
        player0.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L1"));
        player0.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L2"));
        player0.setCash(4000);
        player1.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L3"));
        player1.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L4"));
        player1.setCash(4000);
        String[] test1 = new String[]{"L1"};
        String[] test2 = new String[]{"L3"};
        TradeInputData tradeInput = new TradeInputData("p2", test1, test2, 2000, 0);
        tradeInputBoundary.performAction(tradeInput);
        ArrayList<Property> player1NewProperties = player1.getProperties();
        ArrayList<Property> player0NewProperties = player0.getProperties();
        int player0NewCash = player0.getCash();
        int player1NewCash = player1.getCash();
        //assertions
        assert (player0NewProperties.contains(defCampaignAccess.getCampaign().getPropertyByAbbr("L3")));
        assert (player1NewProperties.contains(defCampaignAccess.getCampaign().getPropertyByAbbr("L1")));
        assert (player0NewCash == 2000);
        assert (player1NewCash == 6000);


    }

    /**
     * GIVES each player 2 properties, and 4000 dollars. Player 0 offers to trade 1 property for one of player 1s properties.
     * Player 1 accepts the trade. Player 0's property is removed, and player 1's property is added.
     *
     * @throws Exception if tile does not exist.
     *                   Tests if the trade would work
     */
    @Test
    public void tradeAcceptPropertiesNoCash() throws Exception {
        // Initialize Advance input data.
        // first we give the playerst the properties and cash they need
        //List of Properties
        List<NormalProperty> testList = new ArrayList<NormalProperty>();
        // Add Normal Properties to the list
        Player player0 = defCampaignAccess.getCampaign().getPlayerAt(0);
        Player player1 = defCampaignAccess.getCampaign().getPlayerAt(1);
        player0.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L1"));
        player0.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L2"));
        player0.setCash(4000);
        player1.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L3"));
        player1.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L4"));
        player1.setCash(4000);
        String[] test1 = new String[]{"L1"};
        String[] test2 = new String[]{"L3"};
        TradeInputData tradeInput = new TradeInputData("p2", test1, test2, 0, 0);
        tradeInputBoundary.performAction(tradeInput);
        ArrayList<Property> player1NewProperties = player1.getProperties();
        ArrayList<Property> player0NewProperties = player0.getProperties();
        //assertions
        assert (player0NewProperties.contains(defCampaignAccess.getCampaign().getPropertyByAbbr("L3")));
        assert (player1NewProperties.contains(defCampaignAccess.getCampaign().getPropertyByAbbr("L1")));


    }
    /**
     * GIVES each player 2 properties, and 4000 dollars. Player 0 offers to trade 1 property for 2000 dollars.
     * Player 1 accepts the trade. Player 0's property is removed, and player 1's property is added.
     * Player 0's money is decreased by 2000, and player 1's money is increased by 2000.
     * @throws Exception if tile does not exist.
     * Tests if the trade would work
     */
    @Test
    public void tradeAcceptOneProperty() throws Exception {
        // Initialize Advance input data.
        // first we give the playerst the properties and cash they need
        //List of Properties
        List<NormalProperty> testList = new ArrayList<NormalProperty>();
        // Add Normal Properties to the list
        Player player0 = defCampaignAccess.getCampaign().getPlayerAt(0);
        Player player1 = defCampaignAccess.getCampaign().getPlayerAt(1);
        player0.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L1"));
        player0.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L2"));
        player0.setCash(4000);
        player1.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L3"));
        player1.addProperty(defCampaignAccess.getCampaign().getPropertyByAbbr("L4"));
        player1.setCash(4000);
        String[] test1 = new String[]{"L1"};
        String[] test2 = new String[]{};
        TradeInputData tradeInput = new TradeInputData("p2", test1, test2, 2000, 0);
        tradeInputBoundary.performAction(tradeInput);
        ArrayList<Property> player1NewProperties = player1.getProperties();
        ArrayList<Property> player0NewProperties = player0.getProperties();
        int player0NewCash = player0.getCash();
        int player1NewCash = player1.getCash();
        //assertions
        assert(player1NewProperties.contains(defCampaignAccess.getCampaign().getPropertyByAbbr("L1")));
        assert(player0NewCash == 2000);
        assert(player1NewCash == 6000);

    }
}
