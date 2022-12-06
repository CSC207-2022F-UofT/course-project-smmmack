package BuildHouseUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import Properties.Property;
import UseCaseUniversal.CommandPerformer;

public class BuildHouseController implements CommandPerformer {

    BuildHouseInputBoundary buildHouseInputBoundary;
    CampaignAccess campaignAccess;

    public BuildHouseController(BuildHouseInputBoundary buildHouseInputBoundary, CampaignAccess campaignAccess){
        this.buildHouseInputBoundary = buildHouseInputBoundary;
        this.campaignAccess = campaignAccess;
    }

    public void performAction(String command) throws Exception{
        Campaign campaign = campaignAccess.getCampaign();
        String[] buildHouseArguments;
        buildHouseArguments = command.split(" ");
        String buildHouseCommand = buildHouseArguments[0];
        int playerIndexBuilds = Integer.parseInt(buildHouseArguments[1]);
        String propertyToBuild = buildHouseArguments[2];
        Property property = campaign.getPropertyByAbbr(propertyToBuild);
        int numberOfHouse = Integer.parseInt(buildHouseArguments[3]);
        BuildHouseInputData buildHouseInputData = new BuildHouseInputData(playerIndexBuilds, property, numberOfHouse);
        buildHouseInputBoundary.performAction(buildHouseInputData);
    }

    public void performCommand(String command){
        try {
            performAction(command);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Getter & Setters:

    public BuildHouseInputBoundary getBuildHouseInputBoundary() {
        return buildHouseInputBoundary;
    }

    public void setBuildHouseInputBoundary(BuildHouseInputBoundary buildHouseInputBoundary) {
        this.buildHouseInputBoundary = buildHouseInputBoundary;
    }

    // Problem with the player index input.
    // "build_house player_name property_name number_of_buildings"
}
