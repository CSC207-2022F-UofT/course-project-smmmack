package buy_property_test;

import ConfirmBuyPropertyUseCase.*;;
import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.DefaultCampaignFactory;
import MainEntities.Player;
import Properties.Property;
import Tiles.PropertyTile;
import ViewModel.InputMapDictionary;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class ConfirmBuyPropertyTest {
    InputMapDictionary inputMapDictionary;
    CampaignAccess campaignAccess;
    ConfirmBuyPropertyInputBoundary confirmBuyPropertyInputBoundary;
    ConfirmBuyPropertyOutputBoundary confirmBuyPropertyOutputBoundary;

    public ConfirmBuyPropertyTest(){
        inputMapDictionary = new InputMapDictionary();
    }

    @BeforeEach
    public void ConfirmBuyPropertySetUp(){
        DefaultCampaignFactory defaultCampaignFactory = new DefaultCampaignFactory(4);
        Campaign defaultCampaign = defaultCampaignFactory.create();
        this.campaignAccess = new CampaignAccess();
        this.campaignAccess.setCampaign(defaultCampaign);
        this.confirmBuyPropertyOutputBoundary= new ConfirmBuyPropertyPresenter();
        this.confirmBuyPropertyInputBoundary = new ConfirmBuyPropertyInteractor(confirmBuyPropertyOutputBoundary,
                campaignAccess);
    }

    /**
     * Tests the successful attempt of purchase.
     * @throws Exception Throws exception otherwise.
     */

    @Test
    public void testConfirmBuyPropertyConfirmedPurchase() throws Exception{
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        player.setCash(10000);
        int playerInitialBalance = player.getCash();
        PropertyTile propertyTile = (PropertyTile) campaignAccess.getCampaign().getTileUnderPlayer(player);
        Property property = propertyTile.getProperty();
        ConfirmBuyPropertyInputData inputData = new ConfirmBuyPropertyInputData(true);
        player.addProperty(property);
        ArrayList<Property> propertiesList =  player.getProperties();
        int playerFinalBalance = player.getCash() - property.getPrice();
        boolean checkPropertyList = propertiesList.contains(property);
        boolean checkBalance = (playerInitialBalance + property.getPrice() == playerFinalBalance);
        boolean checkOwner = (property.getOwner().equals(player));
        Assert.assertTrue(checkPropertyList);
        Assert.assertTrue(checkBalance);
        Assert.assertTrue(checkOwner);
    }


    /**
     * Tests the unsuccessful attempt of purchase.
     * @throws Exception Throws exception otherwise.
     */

    @Test
    public void testConfirmBuyPropertyUnconfirmedPurchase() throws Exception{
        Player player = campaignAccess.getCampaign().getCurrentPlayer();
        player.setCash(1);
        int playerInitialBalance = player.getCash();
        PropertyTile propertyTile = (PropertyTile) campaignAccess.getCampaign().getTileUnderPlayer(player);
        Property property = propertyTile.getProperty();
        ConfirmBuyPropertyInputData inputData = new ConfirmBuyPropertyInputData(true);
        ArrayList<Property> propertiesList =  player.getProperties();
        int playerFinalBalance = player.getCash() - property.getPrice();
        boolean checkPropertyList = propertiesList.contains(property);
        boolean checkBalance = (playerInitialBalance == playerFinalBalance);
        boolean checkOwner = (property.getOwner().equals(player));
        Assert.assertFalse(checkPropertyList);
        Assert.assertTrue(checkBalance);
        Assert.assertFalse(checkOwner);
    }
}