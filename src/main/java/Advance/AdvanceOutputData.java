package Advance;

public class AdvanceOutputData {
    String diceResults;
    String playerLocation;

    public AdvanceOutputData(String diceResults, String playerLocation){
        this.diceResults = diceResults;
        this.playerLocation = playerLocation;
    }

    //Getter and Setter Methods
    public String getDiceResults() {
        return diceResults;
    }

    public String getPlayerLocation() {
        return playerLocation;
    }

    public void setDiceResults(String diceResults) {
        this.diceResults = diceResults;
    }

    public void setPlayerLocation(String playerLocation) {
        this.playerLocation = playerLocation;
    }
}
