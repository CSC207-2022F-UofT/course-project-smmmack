package tradeUseCase;
import UseCaseUniversal.CommandPerformer;


public class TradeController implements CommandPerformer {

    private TradeInputBoundary input;

    public TradeController() {

    }

    public TradeController(TradeInputBoundary input) {
        this.input = input;
    }

    /**
     *
     * @param command
     */


    public void performCommand(String command) {
        String[] words = command.split("\\s+");
        String player = words[1];
        String[] properties1 = words[2].replace("[", "").replace
                ("]", "").split(",\\s*");
        int cash1 = Integer.parseInt(words[3]);
        String[] properties2 = words[4].replace("[", "").replace
                ("]", "").split(",\\s*");
        int cash2 = Integer.parseInt(words[5]);;

        TradeInputData inputData = new TradeInputData(player, properties1,
                properties2, cash1, cash2);
       input.performAction(inputData);
    }


    //getters
    public TradeInputBoundary getInput() {
        return input;
    }

    //setters
    public void setInput(TradeInputBoundary input) {
        this.input = input;
    }



}