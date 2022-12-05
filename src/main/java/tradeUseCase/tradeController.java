package tradeUseCase;
import UseCaseUniversal.CommandPerformer;
import Properties.NormalProperty;


import java.util.ArrayList;



public class tradeController implements CommandPerformer {

    private tradeInputBoundary input;

    public tradeController(tradeInputBoundary input) {
        this.input = input;
    }


    public void performCommand(String command) {
        String[] words = command.split("\\s+");
        String player = words[1];
        String[] properties1 = words[2].replace("[", "").replace
                ("]", "").split(",\\s*");
        int cash1 = Integer.parseInt(words[3]);
        String[] properties2 = words[4].replace("[", "").replace
                ("]", "").split(",\\s*");
        int cash2 = Integer.parseInt(words[5]);;

        tradeInputData inputData = new tradeInputData(player, properties1,
                properties2, cash1, cash2);
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