package build_house_test;

import BuildHouseUseCase.BuildHouseInputBoundary;
import BuildHouseUseCase.BuildHouseInputData;
import BuildHouseUseCase.BuildHouseInteractor;
import BuildHouseUseCase.BuildHouseOutputBoundary;
import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.DefaultCampaignFactory;
import MainEntities.Player;
import Properties.Property;
import Properties.NormalProperty;
import ViewModel.InputMapDictionary;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

public class BuildHouseTest {
    InputMapDictionary inputMapDictionary;
    CampaignAccess campaignAccess;
    BuildHouseOutputBoundary buildHouseOutputBoundary;
    BuildHouseInputBoundary buildHouseInputBoundary;

    @BeforeEach
    public void setBuildHouseTest() {
        DefaultCampaignFactory defaultCampaignFactory = new DefaultCampaignFactory(4);
        Campaign defaultCampaign = defaultCampaignFactory.create();
        this.campaignAccess = new CampaignAccess();
        this.campaignAccess.setCampaign(defaultCampaign);
        this.buildHouseInputBoundary = new BuildHouseInteractor();
        this.buildHouseOutputBoundary = new BuildHouseTestPresenter();
    }

    /**
     * Tests the successful build case for build house.
     * @throws Exception Throws exception otherwise.
     */

    @Test
    public void testBuildHouseSuccessfulBuild() throws Exception {
        BuildHouseInputData buildHouseInputData =
                new BuildHouseInputData("L3", 3);
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        player.setCash(10000);
        int initialBalance = player.getCash();
        Property property = campaignAccess.getCampaign().getPropertyByAbbr(buildHouseInputData.getProperty());
        NormalProperty normalProperty = (NormalProperty) property;
        List<NormalProperty> sameColourList = Arrays.asList(normalProperty.getSameColorGroupProperties());
        List<Property> sameColourPropertyList = new ArrayList<Property>();
        for (int i = 0; i < sameColourList.size(); i++){
            sameColourPropertyList.add((Property) sameColourList.get(i));
            sameColourPropertyList.get(i).assignOwnership(player);
        }
        player.setProperties(sameColourPropertyList);
        Property property1 =
                campaignAccess.getCampaign().getPropertyByAbbr("L4");
        Property property2 =
                campaignAccess.getCampaign().getPropertyByAbbr("L5");
        NormalProperty normalProperty1 = (NormalProperty) property1;
        NormalProperty normalProperty2 = (NormalProperty) property2;
        normalProperty1.setHouseLevel(2);
        normalProperty2.setHouseLevel(1);
        buildHouseInputBoundary.performAction(buildHouseInputData);
        int finalBalance = player.getCash();
        boolean checkHouseLevel = (normalProperty.getHouseLevel() == 3);
        boolean checkBalance = (initialBalance + (normalProperty.getHousePrice() * 3) == finalBalance);
        Assert.assertTrue(checkHouseLevel);
        Assert.assertTrue(checkBalance);
    }

    /**
     * Tests the unsuccessful build house case due to not having enough funds.
     * @throws Exception Throws exception otherwise.
     */

    @Test
    public void testBuildHouseUnsuccessfulBuildNotEnoughFunds() throws Exception {
        BuildHouseInputData buildHouseInputData =
                new BuildHouseInputData("L3", 3);
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        player.setCash(1);
        int initialBalance = player.getCash();
        Property property = campaignAccess.getCampaign().getPropertyByAbbr(buildHouseInputData.getProperty());
        NormalProperty normalProperty = (NormalProperty) property;
        List<NormalProperty> sameColourList = Arrays.asList(normalProperty.getSameColorGroupProperties());
        List<Property> sameColourPropertyList = new ArrayList<Property>();
        for (int i = 0; i < sameColourList.size(); i++){
            sameColourPropertyList.add((Property) sameColourList.get(i));
            sameColourPropertyList.get(i).assignOwnership(player);
        }
        player.setProperties(sameColourPropertyList);
        Property property1 =
                campaignAccess.getCampaign().getPropertyByAbbr("L4");
        Property property2 =
                campaignAccess.getCampaign().getPropertyByAbbr("L5");
        NormalProperty normalProperty1 = (NormalProperty) property1;
        NormalProperty normalProperty2 = (NormalProperty) property2;
        normalProperty1.setHouseLevel(2);
        normalProperty2.setHouseLevel(1);
        buildHouseInputBoundary.performAction(buildHouseInputData);
        boolean checkHouseLevel = (normalProperty.getHouseLevel() == 3);
        boolean checkBalance = initialBalance >= (normalProperty.getHousePrice() * 3);
        Assert.assertTrue(checkHouseLevel);
        Assert.assertFalse(checkBalance);
    }

    /**
     * Tests the unsuccessful build case due to house level error.
     * @throws Exception Throws exception otherwise.
     */

    @Test
    public void testBuildHouseUnsuccessfulBuildHouseLevelError() throws Exception {
        BuildHouseInputData buildHouseInputData =
                new BuildHouseInputData("L6", 3);
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        player.setCash(10000);
        int initialBalance = player.getCash();
        Property property = campaignAccess.getCampaign().getPropertyByAbbr(buildHouseInputData.getProperty());
        NormalProperty normalProperty = (NormalProperty) property;
        List<NormalProperty> sameColourList = Arrays.asList(normalProperty.getSameColorGroupProperties());
        List<Property> sameColourPropertyList = new ArrayList<Property>();
        for (int i = 0; i < sameColourList.size(); i++){
            sameColourPropertyList.add((Property) sameColourList.get(i));
            sameColourPropertyList.get(i).assignOwnership(player);
        }
        player.setProperties(sameColourPropertyList);
        Property property1 =
                campaignAccess.getCampaign().getPropertyByAbbr("L7");
        Property property2 =
                campaignAccess.getCampaign().getPropertyByAbbr("L8");
        NormalProperty normalProperty1 = (NormalProperty) property1;
        NormalProperty normalProperty2 = (NormalProperty) property2;
        normalProperty1.setHouseLevel(0);
        normalProperty2.setHouseLevel(1);
        buildHouseInputBoundary.performAction(buildHouseInputData);
        int finalBalance = player.getCash();
        boolean checkHouseLevel = (normalProperty.getHouseLevel() == 0);
        boolean checkBalance = (initialBalance == finalBalance);
        boolean checkHouseLevelDifference = ((normalProperty.getHouseLevel() +
                buildHouseInputData.getNumberOfHouse() - normalProperty1.getHouseLevel() <= 2));
        Assert.assertTrue(checkHouseLevel);
        Assert.assertTrue(checkBalance);
        Assert.assertFalse(checkHouseLevelDifference);
    }

    /**
     * Tests the unsuccessful build house case due to not owning the same group colour properties.
     * @throws Exception Throws exception otherwise.
     */
    @Test
    public void testBuildHouseUnsuccessfulBuildSameColourPropertyError() throws Exception {
        BuildHouseInputData buildHouseInputData =
                new BuildHouseInputData("L3", 1);
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        player.setCash(1000);
        int initialBalance = player.getCash();
        Property property = campaignAccess.getCampaign().getPropertyByAbbr(buildHouseInputData.getProperty());
        NormalProperty normalProperty = (NormalProperty) property;
        List<Property> sameColourPropertyList = new ArrayList<Property>();
        Property property1 =
                campaignAccess.getCampaign().getPropertyByAbbr("L5");
        sameColourPropertyList.add(property1);
        sameColourPropertyList.add(property);
        property.assignOwnership(player);
        property1.assignOwnership(player);
        // "Lash Miller Chemical Laboratory" must be in the player's property list, to meet same group colour properties
        // criteria, however only "Brennan Hall" & "Morrison Hall" is in the player's property list.
        player.setProperties(sameColourPropertyList);
        NormalProperty normalProperty1 = (NormalProperty) property1;
        normalProperty1.setHouseLevel(2);
        buildHouseInputBoundary.performAction(buildHouseInputData);
        int finalBalance = player.getCash();
        boolean checkHouseLevel = (normalProperty.getHouseLevel() == 0);
        boolean checkBalance = (initialBalance == finalBalance);
        boolean checkOwnsGroupColorProperties = player.ownsColorGroupOf(normalProperty);
        Assert.assertTrue(checkHouseLevel);
        Assert.assertTrue(checkBalance);
        Assert.assertFalse(checkOwnsGroupColorProperties);
    }

    /**
     * Tests the unsuccessful build house case due to maximum house level reach.
     * @throws Exception Throws exception otherwise.
     */
    @Test
    public void testBuildHouseUnsuccessfulBuildMaxHouseLevelExceedError() throws Exception {
        BuildHouseInputData buildHouseInputData =
                new BuildHouseInputData("L21", 6);
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        player.setCash(100000);
        int initialBalance = player.getCash();
        Property property1 = campaignAccess.getCampaign().getPropertyByAbbr(buildHouseInputData.getProperty());
        NormalProperty normalProperty1 = (NormalProperty) property1;
        normalProperty1.setHouseLevel(4);
        List<NormalProperty> sameColourList = Arrays.asList(normalProperty1.getSameColorGroupProperties());
        List<Property> sameColourPropertyList = new ArrayList<Property>();
        for (int i = 0; i < sameColourList.size(); i++){
            sameColourPropertyList.add((Property) sameColourList.get(i));
            sameColourPropertyList.get(i).assignOwnership(player);
        }
        player.setProperties(sameColourPropertyList);
        Property property2 =
                campaignAccess.getCampaign().getPropertyByAbbr("L22");
        NormalProperty normalProperty2 = (NormalProperty) property2;
        normalProperty2.setHouseLevel(5);
        buildHouseInputBoundary.performAction(buildHouseInputData);
        int finalBalance = player.getCash();
        boolean checkHouseLevel = (normalProperty1.getHouseLevel() <= 5);
        boolean checkBalance = (initialBalance == finalBalance);
        boolean checkHouseLevelOfBuilding = (normalProperty1.getHouseLevel() == 4);
        Assert.assertFalse(checkHouseLevel);
        Assert.assertTrue(checkBalance);
    }

}
