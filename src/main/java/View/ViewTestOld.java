package View;
import ViewModel.InputMapDictionary;

import javax.swing.*;
import java.awt.*;

@ Deprecated
public class ViewTestOld {

    public static void main(String[] args) {

        // Testing if the UI works
        // Note: The UI's layout is not proper right now.

        JFrame inputFrame = new JFrame("Input Field");
        inputFrame.setSize(400, 700);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        CommandPanelViewOld testInputField = new CommandPanelViewOld(new InputMapDictionary());
        screens.add(testInputField);
        inputFrame.add(screens);
        inputFrame.setVisible(true);
    }
}
