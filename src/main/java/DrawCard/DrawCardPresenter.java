package DrawCard;
// calls view model

public class DrawCardPresenter implements DrawCardOutputBoundary{
    //update view model in Presenter using command Panel view model with append something

    @Override
    public void performAction(DrawCardOutputData drawCardOutputData) {
        String message = drawCardOutputData.getMessage();
    }
}
