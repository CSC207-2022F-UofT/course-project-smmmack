package file_test;

import view.BoardPanel;
import view.CommandPanel;
import view.PlayersPanel;
import viewmodel.*;

import javax.swing.*;
import java.awt.*;

/**
 * This is not a test class, but simply testing whether BoardPanel works
 */
public class BoardPanelTest {

    public static void main(String[] args) {
        //Set up JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1100, 900);

        //Set up central panel
        JPanel centralPanel = new JPanel();

        //Set up player panel
        PlayersPanel playersPanel = new PlayersPanel();

        //Set up player view model
        PlayerPanelViewModel playerPanelVM = new PlayerPanelViewModel();
        playerPanelVM.addPlayerViewModel(new PlayerViewModel("Max", 0x0000ee));
        playerPanelVM.addListener(playersPanel);
        playerPanelVM.addPlayerViewModel(new PlayerViewModel("Sinem", 0xee0000));
        playerPanelVM.addListener(playersPanel);
        playerPanelVM.notifyListeners();

        //Set up board panel
        BoardPanel boardPanel = new BoardPanel();

        //Set up board view model
        BoardPanelViewModel boardPanelViewModel = new BoardPanelViewModel();
        boardPanelViewModel.setPicPath("gfx/default_board.png");
        boardPanelViewModel.addListener(boardPanel);
        boardPanelViewModel.notifyListeners();

        //Set up command panel
        CommandPanel commandPanel = new CommandPanel();

        //Set up command panel view model
        CommandPanelViewModel commandPanelViewModel = new CommandPanelViewModel();
        commandPanelViewModel.addListener(commandPanel);
        commandPanelViewModel.notifyListeners();

        //Set up input map dictionary
        InputMapDictionary mapDictionary = new InputMapDictionary();

        commandPanel.setViewModel(commandPanelViewModel);
        commandPanel.setMapDictionary(mapDictionary);

        centralPanel.setLayout(new BorderLayout());
        centralPanel.add(boardPanel, BorderLayout.CENTER);
        centralPanel.add(playersPanel, BorderLayout.SOUTH);

        frame.setLayout(new BorderLayout());
        frame.add(centralPanel, BorderLayout.CENTER);
        frame.add(commandPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }
}
