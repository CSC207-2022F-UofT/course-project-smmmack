package EndTurnUseCase;

public class EndTurnOutputData {
    private String message;
    private String nextState;
    private int playerIndex;
    private int playerJailTurn;

    public EndTurnOutputData(String message, String nextState, int playerIndex, int playerJailTurn) {
        this.message = message;
        this.nextState = nextState;
    }

    //getters

    public String getMessage() {
        return message;
    }

    public String getNextState() {
        return nextState;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public int getPlayerJailTurn() {
        return playerJailTurn;
    }

    //Setters

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public void setPlayerJailTurn(int playerJailTurn) {
        this.playerJailTurn = playerJailTurn;
    }
}
