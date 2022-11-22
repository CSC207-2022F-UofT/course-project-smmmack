package GoToJailUserCase;

import GoToJailUserCase.GoToJailInputBoundary;
import GoToJailUserCase.GoToJailInputData;
import GoToJailUserCase.GoToJailOutputData;

public class GoToJailController {
    final GoToJailInputBoundary input;

    public GoToJailController(GoToJailInputBoundary input) {
        this.input = input;
    }

    GoToJailOutputData create (boolean jail) throws Exception {
        GoToJailInputData inputData = new GoToJailInputData(jail);
        return input.create(inputData);
    }
}
