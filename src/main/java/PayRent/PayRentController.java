package PayRent;

/**
 * The PayRentController class takes user input and converts the input into datastructor that can be used by the
 * PayRentInteractor.
 */
public class PayRentController {

    private PayRentInputBoundary payRentInputBoundary;
    private boolean confirmPayRent = false;

    public PayRentController(PayRentInputBoundary payRentInputBoundary) {
        this.payRentInputBoundary = payRentInputBoundary;
    }

    public PayRentController(PayRentInputBoundary payRentInputBoundary, boolean confirmPayRent) {
        this.payRentInputBoundary = payRentInputBoundary;
        this.confirmPayRent = confirmPayRent;
    }

    public void performAction() {
        if (confirmPayRent){
            PayRentInputData payRentInputData = new PayRentInputData(true);
            payRentInputBoundary.performAction(payRentInputData);
        }
        PayRentInputData payRentInputData = new PayRentInputData();
        payRentInputBoundary.performAction(payRentInputData);
    }

    // getters
    public PayRentInputBoundary getPayRentInputBoundary(){
        return this.payRentInputBoundary;
    }

    public boolean getConfirmPayRent(){
        return this.confirmPayRent;
    }

    // setters
    public void setPayRentInputBoundary(PayRentInputBoundary payRentInputBoundary){
        this.payRentInputBoundary = payRentInputBoundary;
    }

    public void setConfirmPayRent(boolean confirmPayRent){
        this.confirmPayRent = confirmPayRent;
    }

}