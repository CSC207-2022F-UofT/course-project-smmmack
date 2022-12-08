package View;

import ViewModel.CommandLineViewModel;
import ViewModel.CommandPanelVMListener;
import ViewModel.CommandPanelViewModel;
import ViewModel.InputMapDictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class CommandPanel extends JPanel implements CommandPanelVMListener {
    private final JTextArea textArea;
    private final JTextField textField;
    private CommandPanelViewModel viewModel;
    private InputMapDictionary mapDictionary;

    public CommandPanel() {
        this(new CommandPanelViewModel());
    }

    public CommandPanel(CommandPanelViewModel viewModel) {
        this.textArea = new JTextArea("OutputArea");
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setColumns(32);

        this.textField = new JTextField("inputField");
        textField.setColumns(32);

        //Listener to the enter key
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    // First, append an input to the view model and call for update, clear the input field
                    String input = textField.getText();
                    InputMapDictionary mapDict = CommandPanel.this.mapDictionary;
                    CommandPanelViewModel viewModel = CommandPanel.this.viewModel;
                    viewModel.appendInput(textField.getText());
                    viewModel.notifyListeners();
                    textField.setText("");

                    // Then, check the input map if the command is written anywhere
                    String[] words = input.split("\\s+");
                    String command = words[0];
                    // If the current input map has the command
                    if (mapDict.hasCommand(command)) {
                        try {
                            mapDict.callOnCurrentMap(input);
                        }
                        //If an exception is thrown from the deeper layers
                        catch (Exception e) {
                            viewModel.appendError(e.getMessage());
                            viewModel.notifyListeners();
                        }
                    }
                    // If the current map doesn't have the command
                    else {
                        viewModel.appendWarning("Command \"" + command + "\" not found");
                        viewModel.notifyListeners();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        });

        this.setLayout(new BorderLayout());

        this.add(textArea, BorderLayout.CENTER);
        this.add(textField, BorderLayout.SOUTH);
        this.setSize(200, 900);
    }

    @Override
    public void performAction(CommandPanelViewModel viewModel) {
        textArea.setText("");
        List<CommandLineViewModel> lines = viewModel.getCommandLineVMs();
        if (lines.size() > 0) {
            for (int i = 0; i < lines.size() && i < 100; i ++) {
                CommandLineViewModel lineVM = lines.get(i);
                textArea.append("[" + lineVM.getType() + "] " + lineVM.getMessage() + "\n\n");
            }
        }
    }

    // setters

    public void setViewModel(CommandPanelViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setMapDictionary(InputMapDictionary mapDictionary) {
        this.mapDictionary = mapDictionary;
    }

    // other setters

    public void removeViewModel() {
        this.viewModel = null;
    }

    public void removeMapDictionary() {
        this.mapDictionary = null;
    }

    //other getters

    public boolean hasViewModel() {
        return !(this.viewModel == null);
    }
}
