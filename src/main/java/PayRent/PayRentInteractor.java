package PayRent;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.Property;
import Tiles.PropertyTile;
import Tiles.Tile;

public class PayRentInteractor implements PayRent.PayRentInputBoundary {

    private PayRent.PayRentOutputBoundary payRentOutputBoundary;
    private CampaignAccess campaignAccess;

    /**
     * Constructor for PayRentInteractor
     * @param payRentOutputBoundary output boundary
     */
    public PayRentInteractor(PayRent.PayRentOutputBoundary payRentOutputBoundary, CampaignAccess campaignAccess) {
        this.payRentOutputBoundary = payRentOutputBoundary;
        this.campaignAccess = campaignAccess;
    }

    /**
     *
     * @param payRentInputData input data for PayRent
     */
    @Override
    public void performAction(PayRentInputData payRentInputData) {

        Player rentee = campaignAccess.getCampaign().getCurrentPlayer();
        Player renter = null;
        Tile propertyLandedOn = campaignAccess.getCampaign().getTileUnderPlayer(rentee);
        int rentMoney = 0;
        if (propertyLandedOn instanceof PropertyTile){
            rentMoney = ((PropertyTile) propertyLandedOn).getProperty().getRent(rentee);
            renter = ((PropertyTile) propertyLandedOn).getProperty().getOwner();
        }

        rentee.loseCash(rentMoney);
        renter.gainCash(rentMoney);

        String outputMessage = rentee + " paid $" +
                rentMoney + "of rent money to " + renter;

        PayRent.PayRentOutputData payRentOutputData = new PayRent.PayRentOutputData(outputMessage);

        payRentOutputBoundary.payRentMessage(rentee.getCash(), renter.getCash(), payRentOutputData);


    }

    // getters
    public PayRent.PayRentOutputBoundary getPayRentOutputBoundary(){
        return payRentOutputBoundary;
    }

    // setters
    public void setPayRentOutputBoundary(PayRent.PayRentOutputBoundary payRentOutputBoundary){
        this.payRentOutputBoundary = payRentOutputBoundary;
    }

}
