package PayRent;

/**
 * The PayRentController class takes user input and converts the input into datastructor that can be used by the
 * PayRentInteractor.
 */
public class PayRentController {

    private PayRentInputBoundary payRentInputBoundary;

    public PayRentController(PayRentInputBoundary payRentInputBoundary) {
        this.payRentInputBoundary = payRentInputBoundary;
    }

    public void performAction() {
        PayRentInputData payRentInputData = new PayRentInputData();
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