package GoToJailUserCase;

public class GoToJailInputData {
    boolean injail;

    public GoToJailInputData(boolean jail) {
        this.injail = jail;
    }

    public boolean getJail() {
        return injail;
    }

    public void setJail(boolean jail) {
        this.injail = jail;
    }
}
