package usecase_buildhouse;

import entities_main.Campaign;
import entities_main.CampaignAccess;
import entities_main.Player;
import entities_properties.NormalProperty;
import entities_properties.Property;

import java.util.ArrayList;
import java.util.Collections;

public class BuildHouseInteractor implements BuildHouseInputBoundary {

    private BuildHouseOutputBoundary buildHouseOutputBoundary;

    private CampaignAccess campaignAccess;

    public BuildHouseInteractor(BuildHouseOutputBoundary buildHouseOutputBoundary, CampaignAccess campaignAccess) {
        this.buildHouseOutputBoundary = buildHouseOutputBoundary;
        this.campaignAccess = campaignAccess;
    }

    public BuildHouseInteractor(){

    }

    // CampaignAccess Getter & Setter:

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    // BuildHouseOutputBoundary Getter & Setter:

    public BuildHouseOutputBoundary getBuildHouseOutputBoundary() {
        return buildHouseOutputBoundary;
    }

    public void setBuildHouseOutputBoundary(BuildHouseOutputBoundary buildHouseOutputBoundary) {
        this.buildHouseOutputBoundary = buildHouseOutputBoundary;
    }

    /** Criteria(s): 1. The player must be the owner of the selected property.
     *               2. The maximum house level must be 5; the player cannot build any house(s)
     *               that exceeds this amount.
     *               3. The player must have enough cash in order to build house(s).
     *               4. The player must own all the same group colour properties for the property
     *               that the player selected to build house(s).
     * @param property    TheProperty that the player wants to build house.
     * @param houseAmount The integer amount of house(s) that the player wants to build on the
     *                    selected property.
     * @return Returns a boolean indicating whether the player satisfied the criteria to build houses
     * on the selected property; true if the player satisfies the criteria, false otherwise.
     */
    public boolean checkEligibility(Property property, int houseAmount) {
        Campaign campaign = campaignAccess.getCampaign();
        Player player = campaign.getCurrentPlayer();
        boolean ownsProperty = player.ownsProperty(property);
        NormalProperty normalProperty = (NormalProperty) property;
        boolean isHouseAmountLimit = normalProperty.getHouseLevel() + houseAmount <= 5;
        boolean hasEnoughCash = player.getCash() >= (houseAmount * (normalProperty.getHousePrice()));
        boolean ownsColourGroup = player.ownsColorGroupOf((NormalProperty) property);

        return ownsProperty && hasEnoughCash && ownsColourGroup && isHouseAmountLimit;
    }

    /** Criteria: The maximum house level difference across the properties in the same group colour
     * must be maximum 2 (The difference between the maximum house level and the minimum house level
     * must be less than  or equal to 2); if the player does not satisfy the criteria, the player
     * cannot build house(s). Further, the maximum house level cannot exceed 5.
     *
     * @param property The property that the player selects to build houses.
     * @param houseAmount The integer house amount that the player wants to build on the selected property.
     * @return Returns boolean if the player satisfies the criteria to build house(s) on the selected
     *         property.
     */
    public boolean checkHouseLevelDifference(Property property, int houseAmount) {
        NormalProperty propertyToBuild = (NormalProperty) property;
        NormalProperty[] normalPropertyListToCompare = propertyToBuild.getSameColorGroupProperties();
        ArrayList<Integer> listHouseLevelCheckAfterBuild = new ArrayList<>();
        int initialHouseLevel = propertyToBuild.getHouseLevel();
        int newHouseLevel = initialHouseLevel + houseAmount;
        int minHouseLevel = 6;
        int maxHouseLevel = -1;

        for(NormalProperty normalProperty: normalPropertyListToCompare){
            if(normalProperty.equals(propertyToBuild)){
                listHouseLevelCheckAfterBuild.add(normalProperty.getHouseLevel() + houseAmount);
            } else {
                listHouseLevelCheckAfterBuild.add(normalProperty.getHouseLevel());
            }
        }
        minHouseLevel = Collections.min(listHouseLevelCheckAfterBuild);
        maxHouseLevel = Collections.max(listHouseLevelCheckAfterBuild);
        return maxHouseLevel - minHouseLevel <= 2 && (newHouseLevel <= 5);
    }

    /**
     *
     * @param property The property that the player selected to build house(s).
     * @param houseAmount The house amount, integer, that the player wants to build
     *                    on the selected property.
     * @return Returns boolean if the player satisfies the criteria that checkEligibility() and
     *         checkHouseLevelDifference() functions check, and builds house(s) on the selected
     *         property; false if the player does not satisfy the criteria that the checkEligibility()
     *         and checkHouseLevelDifference() functions check.
     */
    public boolean buildHouse (Property property,int houseAmount){
        Campaign campaign = campaignAccess.getCampaign();
        if (checkEligibility(property, houseAmount) &&
                checkHouseLevelDifference(property, houseAmount)) {
                NormalProperty normalProperty = (NormalProperty) property;
                campaign.getCurrentPlayer().loseCash(houseAmount * (normalProperty.getHousePrice()));
                normalProperty.setHouseLevel(normalProperty.getHouseLevel() + houseAmount);
                return true;
        } else {
                return false;
        }
    }

    @Override
    public void performAction (BuildHouseInputData inputDataBuildHouse) throws Exception {
        Campaign campaign = campaignAccess.getCampaign();
        int currPlayerIndex = campaign.getCurrPlayerIndex();
        Player currPlayer = campaign.getCurrentPlayer();
        Property propertyToBuild = campaign.getPropertyByAbbr(inputDataBuildHouse.getProperty());
        NormalProperty normalPropertyToBuild = (NormalProperty) propertyToBuild;
        int newHousesAdded = inputDataBuildHouse.getNumberOfHouse();
        int houseAmountToChange = (normalPropertyToBuild.getHouseLevel() + newHousesAdded);
        BuildHouseOutputData buildHouseOutputDataMessage;
        buildHouse(propertyToBuild, inputDataBuildHouse.getNumberOfHouse());
        int playerCashAfterPurchase = currPlayer.getCash() - (newHousesAdded * (normalPropertyToBuild.getHousePrice()));

        try {
            // The player builds house(s) on the selected property, successfully.

            if (buildHouse(propertyToBuild, inputDataBuildHouse.getNumberOfHouse())) {
                buildHouseOutputDataMessage = new BuildHouseOutputData("You have successfully built " +
                        inputDataBuildHouse.getNumberOfHouse() + " house(s) on " +
                        inputDataBuildHouse.getProperty() + ".", true, houseAmountToChange,
                        campaign.getTileIndexByAbbr(inputDataBuildHouse.getProperty()), currPlayerIndex,
                        playerCashAfterPurchase);
                if (normalPropertyToBuild.getHouseLevel() == 5) {
                    buildHouseOutputDataMessage =
                            new BuildHouseOutputData("You have successfully built a hotel on "
                                    + inputDataBuildHouse.getProperty() + ".", true, houseAmountToChange,
                                    campaign.getTileIndexByAbbr(inputDataBuildHouse.getProperty()),
                                    currPlayerIndex, playerCashAfterPurchase);
                    }
            } else {
                // The player cannot build house(s) on the selected property.
                buildHouseOutputDataMessage =
                        new BuildHouseOutputData("Unsuccessful attempt to build," +
                                " please check eligibility.", false, 0,
                                campaign.getTileIndexByAbbr(inputDataBuildHouse.getProperty()), currPlayerIndex,
                                currPlayer.getCash());
                }
        } catch (Exception e) {
            // Catch error.
                buildHouseOutputDataMessage = new BuildHouseOutputData("Error: Attempt to build house" +
                        " cannot proceed.", false, 0,
                        campaign.getTileIndexByAbbr(inputDataBuildHouse.getProperty()),
                        currPlayerIndex, currPlayer.getCash());
            buildHouseOutputBoundary.performAction(buildHouseOutputDataMessage);
            }
            buildHouseOutputBoundary.performAction(buildHouseOutputDataMessage);

        }
    }
