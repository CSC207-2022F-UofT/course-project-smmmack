package PayRent;

public class PayRentController {

    private final PayRentInputBoundary payRentInputBoundary;

    public PayRentController(PayRentInputBoundary payRentInputBoundary) {
        this.payRentInputBoundary = payRentInputBoundary;
    }

    PayRentOutputData create (PayRentInputData newPayRentInputData) {
        PayRentInputData payRentInputData = new PayRentInputData(newPayRentInputData.getRentee(),
                newPayRentInputData.getPropertyLandedOn());
        return payRentInputBoundary.create(payRentInputData);
    }
}