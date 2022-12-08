import EndTurnUseCase.EndTurnContoller;
import EndTurnUseCase.EndTurnInteractor;
import EndTurnUseCase.EndTurnPresenter;
import MainEntities.CampaignAccess;
import ReadCampaignUseCase.*;
import SaveCampaignUseCase.*;
import StartCampaignUseCase.*;
import StartDefCampUseCase.*;
import View.*;
import ViewModel.*;
import ViewModel.InputMap;

import javax.swing.*;
import java.awt.*;

public class GameMain {
    public static void main(String[] args) {
        // Set up Campaign Access
        CampaignAccess campaignAccess = new CampaignAccess();

        // Set up start campaign use case
        StartCampaignInteractor startCampaignInteractor = new StartCampaignInteractor();
        StartCampaignController startCampaignController = new StartCampaignController();
        StartCampaignPresenter startCampaignPresenter = new StartCampaignPresenter();
        startCampaignController.setInputBoundary(startCampaignInteractor);
        startCampaignInteractor.setOutputBoundary(startCampaignPresenter);
        startCampaignInteractor.setCampaignAccess(campaignAccess);

        // Set up start def camp use case
        StartDefCampInteractor startDefCampInteractor = new StartDefCampInteractor();
        StartDefCampController startDefCampController = new StartDefCampController();
        StartDefCampPresenter startDefCampPresenter = new StartDefCampPresenter();
        startDefCampController.setInputBoundary(startDefCampInteractor);
        startDefCampInteractor.setOutputBoundary(startDefCampPresenter);
        startDefCampInteractor.setCampaignAccess(campaignAccess);
        startDefCampInteractor.setStartCampaignInputBoundary(startCampaignInteractor);

        //Set up read campaign use case
        ReadCampaignInteractor readCampaignInteractor = new ReadCampaignInteractor();
        ReadCampaignController readCampaignController = new ReadCampaignController();
        ReadCampaignPresenter readCampaignPresenter = new ReadCampaignPresenter();
        readCampaignController.setInputBoundary(readCampaignInteractor);
        readCampaignInteractor.setCampaignAccess(campaignAccess);
        readCampaignInteractor.setOutputBoundary(readCampaignPresenter);
        readCampaignInteractor.setNextInputBoundary(startCampaignInteractor);

        //Set up save campaign use case
        SaveCampaignInteractor saveCampaignInteractor = new SaveCampaignInteractor();
        SaveCampaignController saveCampaignController = new SaveCampaignController();
        SaveCampaignPresenter saveCampaignPresenter = new SaveCampaignPresenter();
        saveCampaignController.setInputBoundary(saveCampaignInteractor);
        saveCampaignInteractor.setCampaignAccess(campaignAccess);
        saveCampaignInteractor.setOutputBoundary(saveCampaignPresenter);

        //Set up end turn use case
        EndTurnInteractor endTurnInteractor = new EndTurnInteractor();
        EndTurnContoller endTurnContoller = new EndTurnContoller();
        EndTurnPresenter endTurnPresenter = new EndTurnPresenter();
        endTurnContoller.setInputBoundary(endTurnInteractor);
        endTurnInteractor.setOutputBoundary(endTurnPresenter);
        endTurnInteractor.setCampaignAccess(campaignAccess);

        //Set up input maps and input map dictionary
        InputMapDictionary mapDictionary = new InputMapDictionary();

        InputMap anyTimeMap = new InputMap("any_time_commands");

        InputMap unstartedMap = new InputMap("unstarted");
        unstartedMap.addAppendix(anyTimeMap);
        unstartedMap.putCommand("read_campaign", readCampaignController);
        unstartedMap.putCommand("start_default_campaign", startDefCampController);
        mapDictionary.addInputMap(unstartedMap);

        InputMap beforeMoveMap = new InputMap("before_move");
        beforeMoveMap.addAppendix(anyTimeMap);
        beforeMoveMap.putCommand("save_campaign", saveCampaignController);
        mapDictionary.addInputMap(beforeMoveMap);

        InputMap buyLandConfirmMap = new InputMap("buy_land_confirm");
        mapDictionary.addInputMap(buyLandConfirmMap);

        InputMap afterMoveMap = new InputMap("after_move");
        afterMoveMap.addAppendix(anyTimeMap);
        afterMoveMap.putCommand("end_turn", endTurnContoller);
        mapDictionary.addInputMap(afterMoveMap);

        mapDictionary.setInitialMapName("unstarted");
        mapDictionary.setCurrentMapName("unstarted");

        //Link the input map dictionary to the presenters
        startCampaignPresenter.setMapDictionary(mapDictionary);


        //Set up JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1100, 900);

        //Set up central panel
        JPanel centralPanel = new JPanel();

        //Set up player panel
        PlayersPanel playersPanel = new PlayersPanel();

        //Set up player panel view model
        PlayerPanelViewModel playerPanelVM = new PlayerPanelViewModel();
        startCampaignPresenter.setPlayerPanelVM(playerPanelVM);

        playerPanelVM.addListener(playersPanel);
        playerPanelVM.notifyListeners();

        //Set up board panel
        BoardPanel boardPanel = new BoardPanel();

        //Set up board view model
        BoardPanelViewModel boardPanelViewModel = new BoardPanelViewModel();
        boardPanelViewModel.setPicPath("gfx/default_board.png");
        startCampaignPresenter.setBoardPanelVM(boardPanelViewModel);

        boardPanelViewModel.addListener(boardPanel);
        boardPanelViewModel.notifyListeners();

        //Set up command panel
        CommandPanel commandPanel = new CommandPanel();

        //Set up command panel view model
        CommandPanelViewModel commandPanelViewModel = new CommandPanelViewModel();
        saveCampaignPresenter.setCommandPanelVM(commandPanelViewModel);
        startCampaignPresenter.setCommandPanelVM(commandPanelViewModel);
        startDefCampPresenter.setCommandPanelVM(commandPanelViewModel);
        readCampaignPresenter.setCommandPanelVM(commandPanelViewModel);
        commandPanelViewModel.addListener(commandPanel);
        commandPanelViewModel.notifyListeners();

        commandPanel.setViewModel(commandPanelViewModel);
        commandPanel.setMapDictionary(mapDictionary);

        // Set layouts
        centralPanel.setLayout(new BorderLayout());
        centralPanel.add(boardPanel, BorderLayout.CENTER);
        centralPanel.add(playersPanel, BorderLayout.SOUTH);

        frame.setLayout(new BorderLayout());
        frame.add(centralPanel, BorderLayout.CENTER);
        frame.add(commandPanel, BorderLayout.EAST);

        frame.setVisible(true);

    }
}
