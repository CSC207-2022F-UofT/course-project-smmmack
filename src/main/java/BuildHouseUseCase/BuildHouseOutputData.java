package BuildHouseUseCase;

public class BuildHouseOutputData {

    String notification;
    boolean verification;
    int houseAmountToChange;
    int propertyIndex;
    int playerIndex;
    int playersCashAfterPurchase;

    /**
     *
     * @param notification The string notification message that the player receives whether they
     *                     have successfully purchased house(s) or not.
     * @param verification The boolean verification verifying whether the player have successfully
     *                     purchased house(s) or not; true if the player successfully purchased
     *                     house(s), false otherwise.
     * @param houseAmountToChange The integer house amounts indicating the final house amount(s).
     * @param propertyIndex The integer, index of the property selected to build house(s) on.
     * @param playerIndex The integer, index of the (current) player that attempts to build house(s).
     * @param playersCashAfterPurchase The integer cash amount that the player has after purchasing
     *                                 or not purchasing houses.
     */

    public BuildHouseOutputData(String notification, boolean verification,
                                int houseAmountToChange, int propertyIndex, int playerIndex,
                                int playersCashAfterPurchase){
        this.notification = notification;
        this.verification = verification;
        this.houseAmountToChange = houseAmountToChange;
        this.propertyIndex = propertyIndex;
        this.playerIndex = playerIndex;
        this.playersCashAfterPurchase = playersCashAfterPurchase;
    }

    // Getters:

    public String getNotification() {
        return notification;
    }
    public boolean isVerification() {
        return verification;
    }
    public int getHouseAmountToChange(){
        return houseAmountToChange;
    }
    public int getPropertyIndex(){
        return propertyIndex;
    }
    public int getPlayerIndex() {
        return playerIndex;
    }
    public int getPlayersCashAfterPurchase() {
        return playersCashAfterPurchase;
    }

    // Setters:

    public void setVerification(boolean verification) {
        this.verification = verification;
    }
    public void setNotification(String notification) {
        this.notification = notification;
    }
    public void setHouseAmountToChange(int houseAmount) {
        this.houseAmountToChange = houseAmount;
    }
    public void setPropertyIndex(int propertyIndex) {
        this.propertyIndex = propertyIndex;
    }
    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
    public void setPlayersCashAfterPurchase(int playersCashAfterPurchase) {
        this.playersCashAfterPurchase = playersCashAfterPurchase;
    }
}
