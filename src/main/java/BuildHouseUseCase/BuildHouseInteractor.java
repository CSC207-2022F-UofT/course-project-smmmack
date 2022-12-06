package BuildHouseUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.NormalProperty;
import Properties.Property;

public class BuildHouseInteractor implements BuildHouseInputBoundary{

    private final BuildHouseOutputBoundary buildHouseOutputBoundary;

    private CampaignAccess campaignAccess;

    public BuildHouseInteractor(BuildHouseOutputBoundary buildHouseOutputBoundary, CampaignAccess campaignAccess){
        this.buildHouseOutputBoundary = buildHouseOutputBoundary;
        this.campaignAccess = campaignAccess;
    }

    public boolean checkEligibility(Property property, int houseAmount){
        Campaign campaign = campaignAccess.getCampaign();
        Player player = campaign.getCurrentPlayer();
        boolean ownsProperty = player.ownsProperty(property);
        NormalProperty normalProperty = (NormalProperty) property;
        boolean hasEnoughCash = player.getCash() >= (houseAmount * (normalProperty.getHousePrice()));
        boolean ownsColourGroup = player.ownsColorGroupOf((NormalProperty) property);

        return ownsProperty && hasEnoughCash && ownsColourGroup;
    }

    public boolean checkHouseLevelDifference(NormalProperty normalProperty, Property property,
                                             int houseAmount){
        Campaign campaign = campaignAccess.getCampaign();
        NormalProperty propertyToBuild = (NormalProperty) property;

        for(NormalProperty normalProperty1: normalProperty.getSameColorGroupProperties()){
            for(NormalProperty normalProperty2: normalProperty.getSameColorGroupProperties()){
                int compare1 = normalProperty1.getHouseLevel();
                int compare2 = normalProperty2.getHouseLevel();
                int difference0 = Math.abs(compare1 - compare2);
                int difference1 = (propertyToBuild.getHouseLevel() + houseAmount) - normalProperty1.getHouseLevel();
                int difference2 = (propertyToBuild.getHouseLevel() + houseAmount) - normalProperty2.getHouseLevel();
                if ((difference0 > 2) || (difference1 > 2) || (difference2 > 2)){
                    return false;
                }
            }
        } return true;
    }

    public boolean buildHouse(Property property, int houseAmount, NormalProperty normalProperty){
        Campaign campaign = campaignAccess.getCampaign();
        if(checkEligibility(property, houseAmount) &&
                checkHouseLevelDifference(normalProperty, property, houseAmount)){
            campaign.getCurrentPlayer().loseCash(houseAmount * (normalProperty.getHousePrice()));
            normalProperty.setHouseLevel(houseAmount);
            return true;
        } else {
            return  false;
        }
    }

    @Override
    public void performAction(BuildHouseInputData inputDataBuildHouse) throws Exception {
        Campaign campaign = campaignAccess.getCampaign();
        BuildHouseOutputData buildHouseOutputDataMessage;
        buildHouse(inputDataBuildHouse.getProperty(), inputDataBuildHouse.numberOfHouse,
                (NormalProperty) inputDataBuildHouse.getProperty());

        try{
            if(buildHouse(inputDataBuildHouse.getProperty(), inputDataBuildHouse.numberOfHouse,
                    (NormalProperty) inputDataBuildHouse.getProperty())) {
                buildHouseOutputDataMessage = new BuildHouseOutputData("You have successfully built " +
                        inputDataBuildHouse.getNumberOfHouse() + " houses on " +
                        inputDataBuildHouse.property + ".", true);
                if (inputDataBuildHouse.property.getHouseLevel() == 5) {
                    buildHouseOutputDataMessage =
                            new BuildHouseOutputData("You have successfully built a hotel on "
                                    + inputDataBuildHouse.property + ".", true);
                }
            } else {
                buildHouseOutputDataMessage =
                        new BuildHouseOutputData("Unsuccessful attempt to build," +
                                " please check eligibility.", false);
            }
        } catch (Exception e){
            buildHouseOutputDataMessage = new BuildHouseOutputData("Error: Attempt to build house" +
                    " cannot proceed.", false);
        } buildHouseOutputBoundary.performAction(buildHouseOutputDataMessage);

    }
}
