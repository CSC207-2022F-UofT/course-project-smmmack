package PayRent;

public class PayRentController {

    private PayRentInputBoundary payRentInputBoundary;

    public PayRentController(PayRentInputBoundary payRentInputBoundary) {
        this.payRentInputBoundary = payRentInputBoundary;
    }

    public void create (PayRentInputData newPayRentInputData) {
        PayRentInputData payRentInputData = new PayRentInputData(newPayRentInputData.getRentee(),
                newPayRentInputData.getPropertyLandedOn());
        payRentInputBoundary.performAction(payRentInputData);
    }

    // getters
    public PayRentInputBoundary getPayRentInputBoundary(){
        return this.payRentInputBoundary;
    }

    // setters
    public void setPayRentInputBoundary(PayRentInputBoundary payRentInputBoundary){
        this.payRentInputBoundary = payRentInputBoundary;
    }
}