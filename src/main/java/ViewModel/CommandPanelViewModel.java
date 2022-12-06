package ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Command panel in the UI should include two parts: one is an input field of the players, the other is lines of
 * history of commands, including outputs and inputs. CommandPanelViewModel include all history messages, though the
 * actual panel may choose to include only part of it.
 */
public class CommandPanelViewModel {
    private List<CommandLineViewModel> commandLineVMs;

    private List<CommandPanelVMListener> listeners;

   

    public CommandPanelViewModel() {
        this.commandLineVMs = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    //getters

    public List<CommandLineViewModel> getCommandLineVMs() {
        return new ArrayList<>(commandLineVMs);
    }

    //setters

    public void setCommandLineVMs(List<CommandLineViewModel> commandLineVMs) {
        this.commandLineVMs = new ArrayList<>(commandLineVMs);
    }

    //other setters

    public void appendCommandLine(String type, String message) {
        this.commandLineVMs.add(new CommandLineViewModel(type, message));
    }

    public void appendOutput(String message) {
        this.commandLineVMs.add(CommandLineViewModel.getOutputVM(message));
    }

    public void appendInput(String message) {
        this.commandLineVMs.add(CommandLineViewModel.getInputVM(message));
    }

    public void appendWarning(String message) {
        this.commandLineVMs.add(CommandLineViewModel.getWarningVM(message));
    }

    public void appendError(String message) {
        this.commandLineVMs.add(CommandLineViewModel.getErrorVM(message));
    }
    public void addListener(CommandPanelVMListener listener) {
        this.listeners.add(listener);
    }

    public boolean removeListener(CommandPanelVMListener listener) {
        return this.listeners.remove(listener);
    }

    //other methods

    public void notifyListeners() {
        for (CommandPanelVMListener listener: listeners) {
            listener.performAction(this);
        }
    }



