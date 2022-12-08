package GoToJailUserCase;

import MainEntities.CampaignAccess;
import ViewModel.InputMapDictionary;

public class GoToJailInteractor implements GoToJailInputBoundary{
    private GoToJailOutputBoundary output;
    private CampaignAccess campaignAccess;


    public GoToJailInteractor(GoToJailOutputBoundary output, CampaignAccess campaignAccess, InputMapDictionary inputMapDict) {
        this.output = output;
        this.campaignAccess = campaignAccess;
    }

    public GoToJailInteractor (){

    }

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public GoToJailOutputBoundary getOutput() {
        return output;
    }

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    public void setOutput(GoToJailOutputBoundary output) {
        this.output = output;
    }

    /**
     * If the player is in jail, sent him to the jail and shows "You are in jail".
     * @param inputData The input of the game.
     */

    @Override
    public void performAction(GoToJailInputData inputData) throws Exception {
        GoToJailOutputData outputData;
        campaignAccess.getCampaign().getPlayerAt(inputData.getPlayerIndex()).setLocation(inputData.getTileIndex());
        campaignAccess.getCampaign().getPlayerAt(inputData.getPlayerIndex()).setJailTurn(1);
        outputData = new GoToJailOutputData("You are in jail", inputData.getTileIndex(), inputData.getPlayerIndex());
        output.performAction(outputData);
    }


}
