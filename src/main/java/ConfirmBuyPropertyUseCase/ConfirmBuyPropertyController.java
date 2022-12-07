package ConfirmBuyPropertyUseCase;

public class ConfirmBuyPropertyController {

    private ConfirmBuyPropertyInputBoundary inputBoundaryBuyProperty;
    private boolean decision;

    public ConfirmBuyPropertyController(ConfirmBuyPropertyInputBoundary inputBoundaryBuyProperty,
                                        boolean decision) {
        this.inputBoundaryBuyProperty = inputBoundaryBuyProperty;
        this.decision = decision;
    }

    void performAction() throws Exception{
        ConfirmBuyPropertyInputData inputData = new ConfirmBuyPropertyInputData(decision);
        inputBoundaryBuyProperty.performAction(inputData);
    }

    // Getters:

    public ConfirmBuyPropertyInputBoundary getInputBoundaryBuyProperty(){
        return inputBoundaryBuyProperty;
    }

    public boolean getDecision(){
        return decision;
    }

    // Setters:

    public void setInputBoundaryBuyProperty(ConfirmBuyPropertyInputBoundary inputBoundaryBuyProperty){
        this.inputBoundaryBuyProperty = inputBoundaryBuyProperty;
    }

    public void setDecision(boolean decision){
        this.decision = decision;
    }
}
