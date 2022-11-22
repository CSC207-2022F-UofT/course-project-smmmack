package GoToJailUserCase;
import java.io.IOException;


public interface GoToJailOutputBoundary {
    GoToJailOutputData prepareSuccessView(String message);

    GoToJailOutputData prepareFailView(String message);
}
