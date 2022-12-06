package BuyPropertyUseCase;

public class BuyPropertyPresenter implements  BuyPropertyOutputBoundary{

    @Override
    public void create(BuyPropertyOutputData buyPropertyOutputData){
        String message = buyPropertyOutputData.getMessage();
    }

}
