package InitiateBuyPropertyUseCase;

public class InitiateBuyPropertyOutputData {

    String question;
    boolean checkPropertyTileQuestion;

    /**
     *
     * @param question The question, offering the decision to purchase the landed on
     *                 property, introduced to the player when it is confirmed that
     *                 the player is landed on a property tile
     */


    public InitiateBuyPropertyOutputData(String question, boolean checkPropertyTileQuestion){
        this.question = question;
        this.checkPropertyTileQuestion = checkPropertyTileQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public boolean getCheckPropertyTileQuestion() {
        return checkPropertyTileQuestion;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCheckPropertyTileQuestion(boolean checkPropertyTileQuestion) {
        this.checkPropertyTileQuestion = checkPropertyTileQuestion;
    }
}
