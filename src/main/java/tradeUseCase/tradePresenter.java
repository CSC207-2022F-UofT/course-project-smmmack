package tradeUseCase;

import SaveCampaignUseCase.SaveCampaignOutputData;

public class tradePresenter implements tradeOutputBoundary {
    @Override
    public void performAction(SaveCampaignOutputData outputData) {
        System.out.println("Trade menu");

    }
}
