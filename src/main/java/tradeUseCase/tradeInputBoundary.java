package tradeUseCase;

import SaveCampaignUseCase.SaveCampaignInputData;

public interface tradeInputBoundary {

    /**
     * Displays the trade menu.
     * @param input
     */
    void performAction(tradeInputData inputData);

    void preformAction(tradeInputData inputData);
}