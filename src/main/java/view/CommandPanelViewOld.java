package view;

import viewmodel.InputMapDictionary;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
I took the task of working on the CommandPanelView but Max almost finished it without letting anyone know.
So this class is deprecated now.
 */

@ Deprecated
public class CommandPanelViewOld extends JPanel implements ActionListener {
    private final JTextField textField;

    InputMapDictionary inputMapDict;

    JLabel title;

    JTextArea historyDisplay;

    ArrayList<String> historyArr;


    public CommandPanelViewOld(InputMapDictionary inputMapDict) {
        this.inputMapDict = inputMapDict;

        textField = new JTextField();
        textField.addActionListener(this);
        textField.setColumns(50);

        this.title = new JLabel("Command Panel");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        historyDisplay = new JTextArea();
        historyDisplay.setAlignmentX(Component.LEFT_ALIGNMENT);
        historyDisplay.setEditable(false);
        historyDisplay.setSize(1, 25);
        historyArr = new ArrayList<String>();


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(historyDisplay);
        this.add(textField);
    }


    public void actionPerformed(ActionEvent e) {
//        InputMap inputMap = inputMapDict.getCurrentMap();
        String commandInput = textField.getText();

        // Need to change to implement ActionListener.
//        inputLabel.setText("Action in progress. Do not enter anything at this time.");

//        if (inputMap.hasCommand(commandInput)){
//            inputMap.call(commandInput);
//        }
//        else {
//            inputLabel.setText(commandInput + " not found. Please enter a command from the list below.");
//        }

        historyArr.add(commandInput);

        StringBuilder newHistText = new StringBuilder();

        for (int i = historyArr.size() - 1; i >= Math.max(0, (historyArr.size() - 24)); i --){

            newHistText.insert(0, historyArr.get(i) + "\n");
        }

//        newHistText.insert(0, "<html>");
//        newHistText.append("<html>");
        historyDisplay.setText(newHistText.toString());

    }
}
