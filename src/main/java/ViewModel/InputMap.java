package ViewModel;

import UseCaseUniversal.CommandPerformer;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * InputMap maps the strings (user inputs) to the usecases. When a string is put in the text field, the text field
 * finds the corresponding usecase controller, and then the textfield (view component) passes the input string as an
 * argument to the controller.<br>
 * The controller interface comes from UseCaseUniversal package
 */
public class InputMap {
    private String name;
    private Map<String, CommandPerformer> map;
    /**
     * Appendix are input maps that adds to the commands specified in the input map. typically, it's for commands that
     * can be called anytime, so that we don't need to write these commands in every input map.
     */
    private List<InputMap> appendices;

    /**
     * Constructs an InputMap with empty initial command map and no appendix.
     * @param name the name of the input map.
     */
    public InputMap(String name) {
        this(name, new HashMap<>(), new ArrayList<>());
    }

    public InputMap(String name, Map<String, CommandPerformer> map, List<InputMap> appendices) {
        this.name = name;
        this.map = map;
        this.appendices = appendices;
    }

    //getters


    public String getName() {
        return name;
    }

    public HashMap<String, CommandPerformer> getMap() {
        return new HashMap<>(map);
    }

    public ArrayList<InputMap> getAppendices() {
        return new ArrayList<>(appendices);
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setMap(Map<String, CommandPerformer> map) {
        this.map = new HashMap<>(map);
    }

    public void setAppendices(List<InputMap> appendices) {
        this.appendices = new ArrayList<>(appendices);
    }

    //other setters

    public void putCommand(String command, CommandPerformer performer) {
        this.map.put(command, performer);
    }

    public void removeCommand(String command) {
        this.map.remove(command);
    }

    /**
     * Find the command performer corresponding to the given command. If the command is not in the current input map,
     * this method will search in the appendices.
     * @param command the command string (user input)
     * @return the CommandPerformer that corresponds to the given command.
     */
    public CommandPerformer getPerformer(String command) {
        CommandPerformer performer = this.map.get(command);
        if (performer == null) {
            for (InputMap appendix: appendices) {
                performer = appendix.getPerformer(command);
                if (performer != null) {
                    return performer;
                }
            }
        }
        return performer;
    }

    public void addAppendix(InputMap appendix) {
        this.appendices.add(appendix);
    }

    //other getters

    /**
     * Identify whether the command is in the input map or its appendices
     * @param command the command string (user input)
     * @return boolean indicating whether the command is in the input map or its appendices.
     */
    public boolean hasCommand(String command) {
        if (this.map.containsKey(command)) {
            return true;
        } else {
            for (InputMap appendix: appendices) {
                if (appendix.hasCommand(command)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Call the CommandPerformer (use case) that corresponds to the command string.
     * @param command the command string (user input)
     * @throws InvalidParameterException when the input is not found.
     */
    public void call(String command) throws InvalidParameterException {
        CommandPerformer performer = this.getPerformer(command);
        if (performer != null) {
            performer.performCommand(command);
        } else {
            String message = "Command: " + command + " is not found in input map " + this.name + " or its appendices.";
            throw new InvalidParameterException(message);
        }
    }
}
