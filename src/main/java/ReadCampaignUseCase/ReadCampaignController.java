package ReadCampaignUseCase;

import MainEntities.Exceptions.WrongCommandArgumentException;
import UseCaseUniversal.CommandPerformer;

public class ReadCampaignController implements CommandPerformer {
    private ReadCampaignInputBoundary inputBoundary;

    public ReadCampaignController() {

    }

    public ReadCampaignController(ReadCampaignInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The command accepted by this controller should be in the following pattern: <br>
     * read_campaign [file_name] <br>
     * file name: the name of the save file.
     * @param command the command string (user input)
     */
    @Override
    public void performCommand(String command) throws Exception {
        String[] words = command.split("\\s+");
        if (words.length != 2) throw new WrongCommandArgumentException("This command only takes 1 variable");
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
