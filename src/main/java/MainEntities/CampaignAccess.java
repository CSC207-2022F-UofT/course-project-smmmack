package MainEntities;

/**
 * CampaignAccess is a class that grants access of campaigns to the interactors. <br>
 * The purpose of this class is that one use case may change the campaign that this CampaignAccess refers to, and then
 * every single use case will refer to the new assigned campaign.
 */
public class CampaignAccess {
    private Campaign campaign;

    //setters

    /**
     * Use this carefully: this changes the campaign reference of ALL use case interactors!
     * @param campaign the new campaign that is to be assigned to every use case interactor
     */
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    //getters

    public Campaign getCampaign() {
        return campaign;
    }

    //other getters

    public boolean isEmpty() {
        return this.campaign == null;
    }
}
