package GoToJailUserCase;


public interface GoToJailOutputBoundary {
    GoToJailOutputData prepareSuccessView(String message);

    GoToJailOutputData prepareFailureView(String message);
}
