package PayRent;

import MainEntities.Player;

public class PayRentOutputData {

    private Player rentee;
    private Player renter;
    private int rentMoney;

    public PayRentOutputData(Player rentee, Player renter, int rentMoney){
        this.rentee = rentee;
        this.renter = renter;
        this.rentMoney = rentMoney;
    }

    // getters
    public Player getRentee(){
        return this.rentee;
    }

    public Player getRenter(){
        return this.renter;
    }

    public int getRentMoney(){
        return this.rentMoney;
    }


    // setters
    public void setRentee(Player rentee){
        this.rentee = rentee;
    }

    public void setRenter(Player renter){
        this.renter = renter;
    }

    public void setRentMoney(int rentMoneyPaid){
        this.rentMoney = rentMoneyPaid;
    }

}
