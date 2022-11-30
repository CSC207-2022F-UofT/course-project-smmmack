package BuyPropertyUseCase;

public class BuyPropertyController {

    private BuyPropertyInputBoundary inputBuyProperty;
    final boolean decision;

    public BuyPropertyController(BuyPropertyInputBoundary inputBuyProperty, boolean decision) {
        this.inputBuyProperty = inputBuyProperty;
        this.decision = decision;
    }

    void create() throws Exception{
        BuyPropertyInputData inputData = new BuyPropertyInputData(decision);
        inputBuyProperty.create(inputData);
    }

    // Getters:

    public BuyPropertyInputBoundary getInputBuyProperty(){
        return inputBuyProperty;
    }

    public boolean getDecision(){
        return decision;
    }

    // Setter:

    public void setInputBuyProperty(BuyPropertyInputBoundary inputBuyProperty){
        this.inputBuyProperty = inputBuyProperty;
    }
}
