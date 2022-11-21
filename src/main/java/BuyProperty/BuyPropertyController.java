package BuyProperty;

public class BuyPropertyController {

    private final BuyPropertyInputBoundary inputBuyProperty;

    public BuyPropertyController(BuyPropertyInputBoundary inputBuyProperty) {
        this.inputBuyProperty = inputBuyProperty;
    }

    BuyPropertyOutputData create(boolean decision) throws Exception{
        BuyPropertyInputData inputData = new BuyPropertyInputData(decision);
        return inputBuyProperty.create(inputData);
    }
}
