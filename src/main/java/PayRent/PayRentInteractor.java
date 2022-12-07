package PayRent;

import MainEntities.CampaignAccess;
import MainEntities.Player;
import Tiles.PropertyTile;
import Tiles.Tile;

public class PayRentInteractor implements PayRent.PayRentInputBoundary {

    private PayRent.PayRentOutputBoundary payRentOutputBoundary;
    private CampaignAccess campaignAccess;
    Player rentee;
    Player renter;
    Tile propertyLandedOn;
    int rentMoney;

    /**
     * Constructor for PayRentInteractor
     * @param payRentOutputBoundary output boundary
     */
    public PayRentInteractor(PayRent.PayRentOutputBoundary payRentOutputBoundary, CampaignAccess campaignAccess) {
        this.payRentOutputBoundary = payRentOutputBoundary;
        this.campaignAccess = campaignAccess;
        this.rentee = campaignAccess.getCampaign().getCurrentPlayer();
        this.propertyLandedOn = campaignAccess.getCampaign().getTileUnderPlayer(rentee);
        this.renter = ((PropertyTile) propertyLandedOn).getProperty().getOwner();
        this.rentMoney = ((PropertyTile) propertyLandedOn).getProperty().getRent(rentee);
    }

    /**
     *
     * @param payRentInputData input data for PayRent
     */
    @Override
    public void performAction(PayRentInputData payRentInputData) throws Exception {

        rentee.loseCash(rentMoney);
        renter.gainCash(rentMoney);

        String outputMessage = rentee.getName() + " paid $" + rentMoney + "of rent money to " + renter.getName();

        int renteeIndex = campaignAccess.getCampaign().getCurrPlayerIndex();

        int renterIndex = campaignAccess.getCampaign().getPlayerIndex(renter);

        String outputData = renteeIndex+ "@" + renterIndex + "@" + rentee.getCash() + "@" + renter.getCash() + "@" +
                outputMessage;

        PayRent.PayRentOutputData payRentOutputData = new PayRent.PayRentOutputData(outputData);


        payRentOutputBoundary.performAction(String.valueOf(payRentOutputData));


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
