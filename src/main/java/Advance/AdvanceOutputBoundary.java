package Advance;
import java.io.IOException;

public interface AdvanceOutputBoundary {

    AdvanceOutputData prepareSuccessView(String results);
    AdvanceOutputData prepareFailureView(String message);

}
