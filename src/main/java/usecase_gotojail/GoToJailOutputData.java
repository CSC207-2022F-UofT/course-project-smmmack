package usecase_gotojail;

public class GoToJailOutputData {
    private String message;
    private int jailIndex;
    private int playerIndex;

    public GoToJailOutputData(String message, int jailIndex, int playerIndex) {
        this.message = message;
        this.jailIndex = jailIndex;
        this.playerIndex = playerIndex;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
    public int getJailIndex(){
        return jailIndex;
    }

    public void setJailIndex(int jailIndex){
        this.jailIndex = jailIndex;
    }
    public int getPlayerIndex(){
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex){
        this.playerIndex = playerIndex;
    }
}
