package PayRent;

/**
 * The PayRentController class takes user input and converts the input into datastructor that can be used by the
 * PayRentInteractor.
 */
public class PayRentController {

    private PayRent.PayRentInputBoundary payRentInputBoundary;

    public PayRentController(){

    }

    public PayRentController(PayRent.PayRentInputBoundary payRentInputBoundary) {
        this.payRentInputBoundary = payRentInputBoundary;
    }

    public void performAction() throws Exception {
        PayRent.PayRentInputData payRentInputData = new PayRent.PayRentInputData();
        payRentInputBoundary.performAction(payRentInputData);
    }

    // getters
    public PayRent.PayRentInputBoundary getPayRentInputBoundary(){
        return this.payRentInputBoundary;
    }

    // setters
    public void setPayRentInputBoundary(PayRent.PayRentInputBoundary payRentInputBoundary){
        this.payRentInputBoundary = payRentInputBoundary;
    }

}