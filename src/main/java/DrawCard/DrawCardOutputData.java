package DrawCard;

public class DrawCardOutputData {
    String message;

    /**
     *
     * @param message The message when the player has either gained money, lost money or gone bankrupt because of
     *                a card that was drawn
     */

    public DrawCardOutputData(String message) {
        this.message = message;
    }

    //getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
