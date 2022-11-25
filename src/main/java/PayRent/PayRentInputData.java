package PayRent;

import MainEntities.Player;
import Properties.Property;

public class PayRentInputData {

    private Player rentee;
    private Player renter;
    private Property propertyLandedOn;
    private int rentMoney;
    private boolean isMortgaged;

    public PayRentInputData(Player rentee, Property propertyLandedOn){
        this.propertyLandedOn = propertyLandedOn;
        this.rentee = rentee;
        this.renter = propertyLandedOn.getOwner();
        this.rentMoney = propertyLandedOn.getRent(rentee);
        this.isMortgaged = propertyLandedOn.isMortgaged();
    }

    // getters
    public Player getRentee(){
        return this.rentee;
    }

    public Player getRenter(){
        return this.renter;
    }

    public Property getPropertyLandedOn(){
        return this.propertyLandedOn;
    }

    public int getRentMoney(){
        return this.rentMoney;
    }

    public boolean getIsMortgaged(){
        return this.isMortgaged;
    }


    // setters
    public void setRentee(Player rentee){
        this.rentee = rentee;
    }

    public void setRenter(Player renter){
        this.renter = renter;
    }

    public void setRentMoney(int rentMoney){
        this.rentMoney = rentMoney;
    }

    public void setPropertyLandedOn(Property propertyLandedOn){
        this.propertyLandedOn = propertyLandedOn;
    }

    public void setIsMortgaged(boolean isMortgaged){
        this.isMortgaged = isMortgaged;
    }
}
