package DrawCard;

public interface DrawCardOutputBoundary {
    //need to add a create method that takes in an output data I think
    DrawCardOutputData prepareSuccessView(String message);
    DrawCardOutputData prepareFailureView(String message);
}
