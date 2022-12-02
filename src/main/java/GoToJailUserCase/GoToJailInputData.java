package GoToJailUserCase;

public class GoToJailInputData {
    boolean inJail;

    public GoToJailInputData(boolean jail) {
        this.inJail = jail;
    }

    public boolean getJail() {
        return inJail;
    }

    public void setJail(boolean jail) {
        this.inJail = jail;
    }
}
