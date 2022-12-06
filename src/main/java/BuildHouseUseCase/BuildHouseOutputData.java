package BuildHouseUseCase;

public class BuildHouseOutputData {

    String notification;
    boolean verification;

    int playerIndex;

    public BuildHouseOutputData(String notification, boolean verification){
        this.notification = notification;
        this.verification = verification;
    }

    // Getters:

    public String getNotification() {
        return notification;
    }

    public boolean isVerification() {
        return verification;
    }

    // Setters:

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
