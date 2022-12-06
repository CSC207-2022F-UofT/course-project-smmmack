package BuildHouseUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.Property;
import Tiles.PropertyTile;
import Tiles.Tile;

import java.util.Properties;

public class BuildHouseInteractor {

    private final BuildHouseOutputBoundary buildHouseOutputBoundary;

    private CampaignAccess campaignAccess;

    public BuildHouseInteractor(BuildHouseOutputBoundary buildHouseOutputBoundary, CampaignAccess campaignAccess){
        this.buildHouseOutputBoundary = buildHouseOutputBoundary;
        this.campaignAccess = campaignAccess;
    }

    public boolean verifyEligibility(){
        Campaign campaign = campaignAccess.getCampaign();
        int playerIndex = campaign.getPlayerNumber();
        int propertyIndex = campaign.getTileIndexByAbbr();
    }

}
