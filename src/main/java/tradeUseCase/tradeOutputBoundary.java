package tradeUseCase;
import SaveCampaignUseCase.SaveCampaignOutputData;

import java.io.IOException;

public interface tradeOutputBoundary {
    void preformAction(tradeOutputData outputMessage);
}