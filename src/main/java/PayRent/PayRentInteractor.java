package PayRent;

import MainEntities.CampaignAccess;
import MainEntities.Player;
import Tiles.PropertyTile;
import Tiles.Tile;

public class PayRentInteractor implements PayRent.PayRentInputBoundary {

    private PayRent.PayRentOutputBoundary payRentOutputBoundary;
    private CampaignAccess campaignAccess;
    private Player rentee;
    private Player renter;
    private Tile propertyLandedOn;
    private int rentMoney;

    /**
     * Constructor for PayRentInteractor
     * @param payRentOutputBoundary output boundary
     * @param campaignAccess all information about the game: the board, players, etc.
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
     * @param payRentInputData input data for PayRent, this is empty
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
    public CampaignAccess getCampaignAccess(){
        return this.campaignAccess;
    }
    public Player getRentee(){
        return this.rentee;
    }
    public Player getRenter(){
        return this.renter;
    }

    public Tile getPropertyLandedOn(){
        return this.propertyLandedOn;
    }

    public int getRentMoney(){
        return this.rentMoney;
    }

    // setters
    public void setPayRentOutputBoundary(PayRent.PayRentOutputBoundary payRentOutputBoundary){
        this.payRentOutputBoundary = payRentOutputBoundary;
    }

    public void setCampaignAccess(CampaignAccess campaignAccess){
        this.campaignAccess = campaignAccess;
    }

    public void setRentee(Player rentee){
        this.rentee = rentee;
    }

    public void setRenter(Player renter){
        this.renter = renter;
    }

    public void setTile(Tile propertyLandedOn){
        this.propertyLandedOn = propertyLandedOn;
    }

    public void setRentMoney(int rentMoney){
        this.rentMoney = rentMoney;
    }

}
