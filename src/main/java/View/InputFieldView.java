package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ViewModel.InputMap;

public class InputFieldView implements ActionListener{
    private JTextField textField;
    private JButton enterButton;
    private JLabel inputLabel;

    InputMap inputMap;



    public InputFieldView(InputMap inputMap) {
        this.inputMap = inputMap;
        enterButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        inputLabel.setText("Action in progress. Do not enter anything at this time.");
        String commandInput = textField.getText();
        if (inputMap.hasCommand(commandInput)){
            try {
                inputMap.call(commandInput);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
        else {
            inputLabel.setText(commandInput + " not found. Please enter a command from the list below.");
        }
    }
}
