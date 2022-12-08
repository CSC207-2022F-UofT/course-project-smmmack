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

    void performAction() throws Exception{
        InitiateBuyPropertyInputData inputData = new InitiateBuyPropertyInputData(landedOnPropertyTile);
        inputBoundaryInitiatePurchase.performAction(inputData);
    }

    // Getters:
    public InitiateBuyPropertyInputBoundary getInputBoundaryInitiatePurchase() {
        return inputBoundaryInitiatePurchase;
    }

    public boolean getLandedOnPropertyTile(){
        return landedOnPropertyTile;
    }

    // Setters:
    public void setInputInitiatePurchase(InitiateBuyPropertyInputBoundary inputInitiatePurchase) {
        this.inputBoundaryInitiatePurchase = inputInitiatePurchase;
    }
}
