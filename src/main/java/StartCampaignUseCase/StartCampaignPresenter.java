package StartCampaignUseCase;

import ViewModel.*;

import java.util.ArrayList;

public class StartCampaignPresenter implements StartCampaignOutputBoundary {
    private CommandPanelViewModel commandPanelVM;
    private PlayerPanelViewModel playerPanelVM;
    private BoardPanelViewModel boardPanelVM;
    private InputMapDictionary mapDictionary;

    public StartCampaignPresenter() {

    }

    public StartCampaignPresenter(CommandPanelViewModel commandPanelVM, PlayerPanelViewModel playerPanelVM,
                                  BoardPanelViewModel boardPanelVM, InputMapDictionary mapDictionary) {
        this.commandPanelVM = commandPanelVM;
        this.playerPanelVM = playerPanelVM;
        this.boardPanelVM = boardPanelVM;
        this.mapDictionary = mapDictionary;
    }

    //TODO: update this performAction to update all view models
    //TODO: player colors need to be correctly passed from interactors to presenters
    @Override
    public void performAction(StartCampaignOutputData outputData) {
        // Set up player panel VM
        ArrayList<PlayerViewModel> players = new ArrayList<>();
        ArrayList<String> playerNames = outputData.getPlayerNames();
        ArrayList<Integer> playerCashes = outputData.getPlayerCashes();
        ArrayList<Integer> playerLocations = outputData.getPlayerLocations();
        ArrayList<ArrayList<String>> propertyLists = outputData.getPlayerPropertyLists();
        ArrayList<Integer> playerColors = outputData.getPlayerColors();
        for (int i = 0; i < playerNames.size(); i ++) {
            PlayerViewModel pVM = new PlayerViewModel(playerNames.get(i), playerColors.get(i));
            pVM.setCash(playerCashes.get(i));
            pVM.setPosition(playerLocations.get(i));
            pVM.setPropertyAbbrs(propertyLists.get(i));
            players.add(pVM);
        }
        playerPanelVM.setPlayerVMs(players);
        playerPanelVM.notifyListeners();

        // Set up board panel VM
        boardPanelVM.setHeight(outputData.getHeight());
        boardPanelVM.setWidth(outputData.getWidth());
        boardPanelVM.setPlayerVMs(players);
        int[] houseLevels = outputData.getHouseLevels();
        int[] ownershipIndexes = outputData.getOwnershipIndexes();
        boolean[] mortgageList = outputData.getMortgagedList();
        TileViewModel[] tiles = new TileViewModel[boardPanelVM.getSize()];
        for (int i = 0; i < houseLevels.length; i ++) {
            TileViewModel tVM = new TileViewModel();
            tVM.setMortgaged(mortgageList[i]);
            tVM.setHouseLevel(houseLevels[i]);
            tVM.setOwnershipIndex(ownershipIndexes[i]);
            tiles[i] = tVM;
        }
        boardPanelVM.setTileVMs(tiles);
        boardPanelVM.notifyListeners();

        // Append output commandline
        commandPanelVM.appendOutput(outputData.getMessage());
        commandPanelVM.notifyListeners();

        // Change input map
        mapDictionary.setCurrentMapName(outputData.getNextMap());
    }

    //getters

    public CommandPanelViewModel getCommandPanelVM() {
        return commandPanelVM;
    }

    public InputMapDictionary getMapDictionary() {
        return mapDictionary;
    }

    public BoardPanelViewModel getBoardPanelVM() {
        return boardPanelVM;
    }

    public PlayerPanelViewModel getPlayerPanelVM() {
        return playerPanelVM;
    }

    //setters

    public void setCommandPanelVM(CommandPanelViewModel commandPanelVM) {
        this.commandPanelVM = commandPanelVM;
    }

    public void setMapDictionary(InputMapDictionary mapDictionary) {
        this.mapDictionary = mapDictionary;
    }

    public void setPlayerPanelVM(PlayerPanelViewModel playerPanelVM) {
        this.playerPanelVM = playerPanelVM;
    }

    public void setBoardPanelVM(BoardPanelViewModel boardPanelVM) {
        this.boardPanelVM = boardPanelVM;
    }
}
