package GoToJailUserCase;


public interface GoToJailOutputBoundary {
    void create(GoToJailOutputData outputData) throws Exception;

    void performAction(GoToJailOutputData output);
}
