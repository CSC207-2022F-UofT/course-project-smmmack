package ConfirmBuyPropertyUseCase;

import UseCaseUniversal.CommandPerformer;

public class ConfirmBuyPropertyController implements CommandPerformer {

    private ConfirmBuyPropertyInputBoundary inputBoundaryBuyProperty;
    private boolean decision;

    public ConfirmBuyPropertyController(ConfirmBuyPropertyInputBoundary inputBoundaryBuyProperty,
                                        boolean decision) {
        this.inputBoundaryBuyProperty = inputBoundaryBuyProperty;
        this.decision = decision;
    }

    void performAction(String command) throws Exception{
        boolean decision;
        if(command.equals("yes")) {
            decision = true;
        } else {
            decision = false;
        }
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

    public void performCommand(String command){
        try {
            performAction(command);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
