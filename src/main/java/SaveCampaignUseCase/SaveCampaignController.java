package SaveCampaignUseCase;

import MainEntities.Exceptions.WrongCommandArgumentException;
import UseCaseUniversal.CommandPerformer;

public class SaveCampaignController implements CommandPerformer {
    private SaveCampaignInputBoundary inputBoundary;

    public SaveCampaignController() {

    }

    public SaveCampaignController(SaveCampaignInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The command accepted by this controller should be in the following pattern: <br>
     * save_campaign [file_name] <br>
     * file name: the name of the save file.
     * @param command the command string (user input)
     */
    public void performCommand(String command) throws Exception {
        String[] words = command.split("\\s+");
        if (words.length != 2)
            throw new WrongCommandArgumentException("This command only takes in one parameter");
        String relativePath = words[1];
        SaveCampaignInputData inputData = new SaveCampaignInputData(relativePath);
        inputBoundary.performAction(inputData);
    }

    //getters

    public SaveCampaignInputBoundary getInputBoundary() {
        return inputBoundary;
    }

    //setters

    public void setInputBoundary(SaveCampaignInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
