package viewmodel;

/**
 * CommandLineViewModel is a single line of command that need to be shown on the command lines panel
 */
public class CommandLineViewModel {

    private String type;
    private String message;
    //TODO: a static map that maps different types of message to their colors

    /**
     * A CommandLineViewModel constructor that takes in two variables: type and message <br>
     * type should be one of the following: "output", "input", "warning", or "error" <br>
     * "output": normal program output <br>
     * "input": player input history <br>
     * "warning": minor problem happened, but the program still works. For example: player had an invalid input. <br>
     * "error": something really wrong happened in the program, some code might need to be changed. For example: an
     * exception is thrown from the entities or use case layer, and it's not because of wrong user input <br>
     * @param type the type of this line of command
     * @param message the message of this line of command
     */
    public CommandLineViewModel(String type, String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * Create a new CommandLineViewModel that is type "output".
     * @param message the message of this line of command
     * @return a new CommandLineViewModel of type "output" with the given message
     */
    public static CommandLineViewModel getOutputVM(String message) {
        return new CommandLineViewModel("output", message);
    }

    /**
     * Create a new CommandLineViewModel that is type "input".
     * @param message the message of this line of command
     * @return a new CommandLineViewModel of type "input" with the given message
     */
    public static CommandLineViewModel getInputVM(String message) {
        return new CommandLineViewModel("input", message);
    }

    /**
     * Create a new CommandLineViewModel that is type "warning".
     * @param message the message of this line of command
     * @return a new CommandLineViewModel of type "warning" with the given message
     */
    public static CommandLineViewModel getWarningVM(String message) {
        return new CommandLineViewModel("warning", message);
    }

    /**
     * Create a new CommandLineViewModel that is type "error".
     * @param message the message of this line of command
     * @return a new CommandLineViewModel of type "error" with the given message
     */
    public static CommandLineViewModel getErrorVM(String message) {
        return new CommandLineViewModel("warning", message);
    }

    //setters

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }

    //getters

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

}

