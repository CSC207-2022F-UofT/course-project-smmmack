package InitiateBuyPropertyUseCase;

public class InitiateBuyPropertyController{

    private InitiateBuyPropertyInputBoundary inputBoundaryInitiatePurchase;
    private boolean landedOnPropertyTile;

    public InitiateBuyPropertyController(InitiateBuyPropertyInputBoundary inputBoundaryInitiatePurchase,
                                         boolean landedOnPropertyTile) {
        this.inputBoundaryInitiatePurchase = inputBoundaryInitiatePurchase;
        this.landedOnPropertyTile = landedOnPropertyTile;
    }

    public InitiateBuyPropertyController(){

    }

    // Getters & Setters:
    public InitiateBuyPropertyInputBoundary getInputBoundaryInitiatePurchase() {
        return inputBoundaryInitiatePurchase;
    }

    public boolean getLandedOnPropertyTile(){
        return landedOnPropertyTile;
    }

    public void setInputBoundaryInitiatePurchase(InitiateBuyPropertyInputBoundary inputBoundaryInitiatePurchase) {
        this.inputBoundaryInitiatePurchase = inputBoundaryInitiatePurchase;
    }

    public void setLandedOnPropertyTile(boolean landedOnPropertyTile) {
        this.landedOnPropertyTile = landedOnPropertyTile;
    }

    void performAction() throws Exception{
        InitiateBuyPropertyInputData inputData = new InitiateBuyPropertyInputData(landedOnPropertyTile);
        inputBoundaryInitiatePurchase.performAction(inputData);
    }
}
