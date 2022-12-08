package GoToJailUserCase;

public class GoToJailInputData {
    private boolean inJail;
    private int playerIndex;
    private int tileIndex;

    public GoToJailInputData(boolean jail, int playerIndex, int tileIndex) {
        this.inJail = jail;
        this.playerIndex = playerIndex;
        this.tileIndex = tileIndex;
    }

    public boolean getJail() {
        return inJail;
    }


    public int getPlayerIndex(){
        return playerIndex;
    }

    public int getTileIndex(){
        return tileIndex;
    }


}
