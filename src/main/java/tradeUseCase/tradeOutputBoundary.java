package tradeUseCase;
import SaveCampaignUseCase.SaveCampaignOutputData;

import java.io.IOException;

public interface tradeOutputBoundary {
    void performAction(tradeOutputData outputMessage);

    void preformAction(tradeOutputData outputMessage);
}