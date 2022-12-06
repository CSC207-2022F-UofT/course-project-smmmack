package tradeUseCase;
import UseCaseUniversal.CommandPerformer;
import Properties.NormalProperty;


import java.util.ArrayList;


public class tradeController implements CommandPerformer {
    //change to private`

    private tradeInputBoundary input;

    public tradeController(tradeInputBoundary input) {
        this.input = input;
    }


    public void performCommand(String command) {
        String[] words = command.split("\\s+");
        String player = words[0];
        tradeInputData inputData = new tradeInputData(player, new ArrayList<NormalProperty>(),
                new ArrayList<NormalProperty>(), 0, 0);
       input.performAction(inputData);
    }

    //getters
    public tradeInputBoundary getInput() {
        return input;
    }

    //setters
    public void setInput(tradeInputBoundary input) {
        this.input = input;
    }



}