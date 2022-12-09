package usecase_advance;
import usecase_gotojail.GoToJailInputBoundary;
import usecase_gotojail.GoToJailInputData;
import usecase_initiatebuyproperty.InitiateBuyPropertyInputBoundary;
import usecase_initiatebuyproperty.InitiateBuyPropertyInputData;
import entities_main.Player;
import entities_main.GameBoard;
import usecase_payrent.PayRentInputBoundary;
import usecase_payrent.PayRentInputData;
import entities_tiles.*;
import entities_main.CampaignAccess;
import usecase_drawcard.*;


public class AdvanceInteractor implements AdvanceInputBoundary{
    /*
    The Advance use case advances the player to a specific location on the board depending on the dice roll passed by
    AdvanceController.
     */

    AdvanceOutputBoundary output;
    CampaignAccess campaign;
    DrawCardInputBoundary drawCardInputBoundary;
    InitiateBuyPropertyInputBoundary initiateBuyPropertyIP;
    PayRentInputBoundary payRentInputBoundary;

    GoToJailInputBoundary jailInputBoundary;

    public AdvanceInteractor(AdvanceOutputBoundary output, CampaignAccess campaign, DrawCardInputBoundary
            drawCardInputBoundary, InitiateBuyPropertyInputBoundary initiateBuyPropertyIP, PayRentInputBoundary
                             payRentInputBoundary, GoToJailInputBoundary jailInputBoundary) {
        this.output = output;
        this.campaign = campaign;
        this.drawCardInputBoundary = drawCardInputBoundary;
        this.initiateBuyPropertyIP = initiateBuyPropertyIP;
        this.payRentInputBoundary = payRentInputBoundary;
        this.jailInputBoundary = jailInputBoundary;
    }

    public AdvanceInteractor(){

    }

    /**
     * Less constructor variables for testing.
     */
    public AdvanceInteractor(AdvanceOutputBoundary output, CampaignAccess campaign) {
        this.output = output;
        this.campaign = campaign;
    }

    /**
     * Advances the player to a new tile based off of diceSum. Calls on performTileAction to allow the user to
     * perform the tile's corresponding action.
     * @param diceSum the result of two dice rolls
     * @return if inputMap should be updated in ViewModel layer.
     */
    public boolean advancePlayer(int diceSum) throws Exception {

        Player player = campaign.getCampaign().getCurrentPlayer();
        GameBoard board = campaign.getCampaign().getBoard();

        int tilesMoved = diceSum + player.getLocation();

        // If the player moves past start, add $200 to the player's cash
        if (tilesMoved > board.getSize()){
            player.setLocation(tilesMoved - board.getSize());
            player.gainCash(200);
        }
        else {
            player.setLocation(tilesMoved);
        }

        return performTileAction(player.getLocation());
    }

    /**
     * Allows the player to make an action based off the tile they are on.
     * @param tileIndex the index of the tile that the player is on.
     * @return if inputMap should be updated in ViewModel layer.
     */
    public boolean performTileAction(int tileIndex) throws Exception {
        GameBoard board = campaign.getCampaign().getBoard();
        Tile tile = board.getTileAt(tileIndex);

        if (tile instanceof DrawCardTile){
            String deckType = ((DrawCardTile) tile).getDeck().getType();
            DrawCardInputData drawCardInputData = new DrawCardInputData(deckType);
            drawCardInputBoundary.performAction(drawCardInputData, deckType);
            return true;

        } else if (tile instanceof GoToJailTile) {

            Tile jailTile = ((GoToJailTile) tile).getJailTile();
            int jailTileIndex = campaign.getCampaign().getBoard().getTileIndex(jailTile);

            GoToJailInputData jailInputData = new GoToJailInputData(true,
                    campaign.getCampaign().getCurrPlayerIndex(), jailTileIndex);
            jailInputBoundary.performAction(jailInputData);
            return true;

        } else if (tile instanceof JailTile) {
            // Do nothing as the tile has no user actions.
            return true;

        } else if (tile instanceof ParkingTile) {
            // Do nothing as the tile has no user actions.
            return true;

        } else if (tile instanceof PropertyTile) {
            // Calls on BuyProperty and PayRent use case after it is finished.
            // What happens if the property is owned? If it isn't?

            if (((PropertyTile) tile).getProperty().isOwnerless()) {
                InitiateBuyPropertyInputData initiateBuyPropertyInput =
                        new InitiateBuyPropertyInputData(true);
                initiateBuyPropertyIP.performAction(initiateBuyPropertyInput);
                return false;
            }
            else { // Call PayRent use case
                PayRentInputData payRentInput = new PayRentInputData();
                payRentInputBoundary.performAction(payRentInput);
                return true;
            }
        } else if (tile instanceof StartTile) {
            return true;
        }
        else{
            throw new Exception("Tile not found.");
        }
    }


    /**
     * Performs the Advance action by moving the player forwards the appropriate number of tiles. The Advance use case
     * will be called by the RollDice use case and Card use cases.
     * Precondition: The player has confirmed that they will advance, either by confirming their dice roll or card.
     * @param input AdvanceInputData containing if the user confirmed the advance or not.
     * @throws Exception if the tile that the user lands on is not valid
     */
    @Override
    public void performAction(AdvanceInputData input) throws Exception {

        Player player = campaign.getCampaign().getCurrentPlayer();
        boolean updateInputMap;

        try {
            if (input.isConfirmRoll()) {
                updateInputMap = advancePlayer(input.diceSum);
                AdvanceOutputData outputMessage =
                        new AdvanceOutputData("You have landed on this tile: " + player.getLocation(),
                                true, player.getLocation(), campaign.getCampaign().getCurrPlayerIndex(),
                                updateInputMap);
                output.performAction(outputMessage);
            }
        }
        catch (Exception e){
            AdvanceOutputData outputMessage =
                    new AdvanceOutputData("Error: Tile not found", false,
                            player.getLocation(), campaign.getCampaign().getCurrPlayerIndex(), false);
            output.performAction(outputMessage);
        }
    }

    // Getters and Setters

    public AdvanceOutputBoundary getOutput() {
        return output;
    }

    public CampaignAccess getCampaign() {
        return campaign;
    }

    public DrawCardInputBoundary getDrawCardInputBoundary() {
        return drawCardInputBoundary;
    }

    public GoToJailInputBoundary getJailInputBoundary() {
        return jailInputBoundary;
    }

    public InitiateBuyPropertyInputBoundary getInitiateBuyPropertyIP() {
        return initiateBuyPropertyIP;
    }

    public PayRentInputBoundary getPayRentInputBoundary() {
        return payRentInputBoundary;
    }

    public void setOutput(AdvanceOutputBoundary output) {
        this.output = output;
    }

    public void setCampaign(CampaignAccess campaign) {
        this.campaign = campaign;
    }

    public void setDrawCardInputBoundary(DrawCardInputBoundary drawCardInputBoundary) {
        this.drawCardInputBoundary = drawCardInputBoundary;
    }

    public void setInitiateBuyPropertyIP(InitiateBuyPropertyInputBoundary initiateBuyPropertyIP) {
        this.initiateBuyPropertyIP = initiateBuyPropertyIP;
    }

    public void setJailInputBoundary(GoToJailInputBoundary jailInputBoundary) {
        this.jailInputBoundary = jailInputBoundary;
    }

    public void setPayRentInputBoundary(PayRentInputBoundary payRentInputBoundary) {
        this.payRentInputBoundary = payRentInputBoundary;
    }
}
