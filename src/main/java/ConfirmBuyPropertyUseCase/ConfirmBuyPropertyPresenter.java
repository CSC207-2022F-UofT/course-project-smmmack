package ConfirmBuyPropertyUseCase;

public class ConfirmBuyPropertyPresenter implements ConfirmBuyPropertyOutputBoundary {

    @Override
    public void performAction(ConfirmBuyPropertyOutputData buyPropertyOutputData){
        String message = buyPropertyOutputData.getMessage();
    }
    // 3 more variables: 1 boolean indicating of confirmPurchase at the BuyPropertyOutPutData.
    // playerIndex. Which player at which index bought the property.
    // propertyIndex. Which property at what index has been bought?
}
