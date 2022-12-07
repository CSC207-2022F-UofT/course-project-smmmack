package StartCampaignUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.NormalProperty;
import Properties.Property;
import Tiles.PropertyTile;
import Tiles.Tile;

import java.util.ArrayList;

public class StartCampaignInteractor implements StartCampaignInputBoundary {

    private CampaignAccess campaignAccess;
    private StartCampaignOutputBoundary outputBoundary;

    public StartCampaignInteractor(CampaignAccess campaignAccess, StartCampaignOutputBoundary outputBoundary) {
        this.campaignAccess = campaignAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void performAction(StartCampaignInputData inputData) {
        Campaign campaign = campaignAccess.getCampaign();

        // load board data
        int width = campaign.getBoardWidth();
        int height = campaign.getBoardHeight();
        int boardSize = campaign.getBoardSize();
        int[] houseLevels = new int[boardSize];
        int[] ownershipIndexes = new int[boardSize];
        boolean[] mortgagedList = new boolean[boardSize];
        Tile[] tiles = campaign.getBoard().getTiles();
        for (int i = 0; i < boardSize; i ++) {
            if (tiles[i] instanceof PropertyTile) {
                Property p = ((PropertyTile) tiles[i]).getProperty();
                ownershipIndexes[i] = campaign.getPlayerIndex(p.getOwner());
                mortgagedList[i] = p.isMortgaged();
                if (p instanceof NormalProperty) {
                    houseLevels[i] = ((NormalProperty) p).getHouseLevel();
                } else {
                    houseLevels[i] = 0;
                }
            } else {
                houseLevels[i] = 0;
                ownershipIndexes[i] = -1;
                mortgagedList[i] = false;
            }
        }

        // load player data
        int playerNum = campaign.getPlayerNumber();
        ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<Integer> playerCashes = new ArrayList<>();
        ArrayList<ArrayList<String>> playerPropertyLists = new ArrayList<>();
        ArrayList<Integer> playerLocations = new ArrayList<>();
        //TODO: player colors need to be correctly passed from interactors to presenters
        ArrayList<Integer> playerColors = new ArrayList<>();
        for (int i = 0; i < playerNum; i ++) {
            Player player = campaign.getPlayerAt(i);
            playerNames.add(player.getName());
            playerCashes.add(player.getCash());
            ArrayList<String> propertyList = new ArrayList<>();
            for (Property p: player.getProperties()) {
                propertyList.add(p.getAbbreviation());
            }
            playerPropertyLists.add(propertyList);
            playerLocations.add(player.getLocation());
            playerColors.add(player.getColor());
        }

        // Put a new String in the command lines
        String campaignName = inputData.getCampaignName();
        Player currPlayer = campaign.getCurrentPlayer();
        String playerName = currPlayer.getName();
        String message = "Starting campaign: " + campaignName + ", player " + playerName + "'s turn.";
        String nextMap = "before_move";

        // Create the output data
        StartCampaignOutputData outputData = new StartCampaignOutputData();
        outputData.setMessage(message);
        outputData.setNextMap(nextMap);
        outputData.setHeight(height);
        outputData.setWidth(width);
        outputData.setPlayerCashes(playerCashes);
        outputData.setPlayerNames(playerNames);
        outputData.setPlayerLocations(playerLocations);
        outputData.setPlayerPropertyLists(playerPropertyLists);
        outputData.setHouseLevels(houseLevels);
        outputData.setOwnershipIndexes(ownershipIndexes);
        outputData.setMortgagedList(mortgagedList);

        // Call the presenter
        outputBoundary.performAction(outputData);
    }

    //getter

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public StartCampaignOutputBoundary getOutputBoundary() {
        return outputBoundary;
    }

    //setters

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    public void setOutputBoundary(StartCampaignOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    //other getters

    public Campaign getCampaign() {
        return campaignAccess.getCampaign();
    }

    //other setters

    public void setCampaign(Campaign campaign) {
        campaignAccess.setCampaign(campaign);
    }
}
