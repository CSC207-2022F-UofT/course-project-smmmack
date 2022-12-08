package usecase_payrent;

/**
 * The PayRentController class takes user input and converts the input into datastructor that can be used by the
 * PayRentInteractor.
 */
public class PayRentController {

    private usecase_payrent.PayRentInputBoundary payRentInputBoundary;

    public PayRentController(){}

    public PayRentController(usecase_payrent.PayRentInputBoundary payRentInputBoundary) {
        this.payRentInputBoundary = payRentInputBoundary;
    }

    public void performAction() throws Exception {
        usecase_payrent.PayRentInputData payRentInputData = new usecase_payrent.PayRentInputData();
        payRentInputBoundary.performAction(payRentInputData);
    }

    // getters
    public usecase_payrent.PayRentInputBoundary getPayRentInputBoundary(){
        return this.payRentInputBoundary;
    }

    // setters
    public void setPayRentInputBoundary(usecase_payrent.PayRentInputBoundary payRentInputBoundary){
        this.payRentInputBoundary = payRentInputBoundary;
    }

}