package GoToJailUserCase;

public class GoToJailOutputData {
    private String message;

    public GoToJailOutputData(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
