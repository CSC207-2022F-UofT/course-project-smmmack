package PayRent;

public class PayRentInputData {

    private String rentee;
    private int renteeCash;
    private String renter;
    private int renterCash;
    private String propertyLandedOn;
    private int rentMoney = 0;
    private boolean isMortgaged;
    private boolean confirmPayRent = true;

    /**
     * Constructor automatically called when rentee lands on the property
     */
    public PayRentInputData(){

    }

    /**
     * Constructor called when the rentee manually clicks confirm to pay rent since they fail to pay rent the first time
     * because they didn't have enough money to pay the rent
     * @param confirmPayRent true if rentee confirms to pay the rent and false otherwise
     */
    public PayRentInputData(boolean confirmPayRent){
        this.confirmPayRent = confirmPayRent;
    }

    // getters
    public String getRentee(){
        return this.rentee;
    }

    public int getRenteeCash(){
        return this.renteeCash;
    }

    public String getRenter(){
        return this.renter;
    }

    public int getRenterCash(){
        return this.renterCash;
    }

    public String getPropertyLandedOn(){
        return this.propertyLandedOn;
    }

    public int getRentMoney(){
        return this.rentMoney;
    }

    public boolean getIsMortgaged(){
        return this.isMortgaged;
    }
    public boolean getConfirmPayRent(){
        return this.confirmPayRent;
    }


    // setters
    public void setRentee(String rentee){
        this.rentee = rentee;
    }

    public void setRenteeCash(int renteeCash){
        this.renteeCash = renteeCash;
    }

    public void setRenter(String renter){
        this.renter = renter;
    }

    public void setRenterCash(int renterCash){
        this.renterCash = renterCash;
    }

    public void setRentMoney(int rentMoney){
        this.rentMoney = rentMoney;
    }

    public void setPropertyLandedOn(String propertyLandedOn){
        this.propertyLandedOn = propertyLandedOn;
    }

    public void setIsMortgaged(boolean isMortgaged){
        this.isMortgaged = isMortgaged;
    }

    public void setConfirmPayRent(boolean confirmPayRent){
        this.confirmPayRent = confirmPayRent;
    }

}
