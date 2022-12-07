package InitiateBuyPropertyUseCase;

public class InitiateBuyPropertyOutputData {

    String question;
    boolean response;

    /**
     *
     * @param question The question, offering the decision to purchase the landed on
     *                 property, introduced to the player when it is confirmed that
     *                 the player is landed on a property tile.
     * @param response The response, the decision of the player; the response can either
     *                 be true or false: true if the player wishes to attempt purchasing
     *                 the landed on property, false otherwise.
     */


    public InitiateBuyPropertyOutputData(String question, boolean response){
        this.question = question;
        this.response = response;
    }

    public String getQuestion() {
        return question;
    }

    public boolean getResponse(){
        return response;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setResponse(boolean response){
        this.response = response;
    }
}
