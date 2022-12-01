package ReadCampaignUseCase;

import UseCaseUniversal.CommandPerformer;

import java.security.InvalidParameterException;

public class ReadCampaignController implements CommandPerformer {
    private ReadCampaignInputBoundary inputBoundary;

    public ReadCampaignController(ReadCampaignInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @Override
    public void performCommand(String command) {
        String[] words = command.split("\\s+");
        if (words.length != 2) throw new InvalidParameterException("This command only takes 1 variable");
        ReadCampaignInputData inputData = new ReadCampaignInputData(words[1]);
        inputBoundary.performAction(inputData);
    }

    //setters

    public void setInputBoundary(ReadCampaignInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    //getters

    public ReadCampaignInputBoundary getInputBoundary() {
        return inputBoundary;
    }
}
