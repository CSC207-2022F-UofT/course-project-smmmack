package PayRent;

public class PayRentInputData {

    private String rentee;
    private int renteeCash;
    private String renter;
    private int renterCash;
    private String propertyLandedOn;
    private int rentMoney = 0;

    public PayRentInputData(){

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
}
