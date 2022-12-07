package tradeUseCase;
import ViewModel.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class tradePresenter implements tradeOutputBoundary {
    private CommandPanelViewModel commandPanelVM;
    private PlayerPanelViewModel playerPanelVM;
    private PlayerViewModel playerVM;
    private BoardPanelViewModel boardPanelVM;

    private TileViewModel tileVM;

    public tradePresenter(CommandPanelViewModel commandPanelVM, PlayerPanelViewModel playerPanelVM, TileViewModel tileVM, PlayerViewModel playerVM, BoardPanelViewModel boardPanelVM) {
        this.commandPanelVM = commandPanelVM;
        this.playerPanelVM = playerPanelVM;
        this.tileVM = tileVM;
        this.playerVM = playerVM;
        this.boardPanelVM = boardPanelVM;
    }
    @Override
    public void performAction(tradeOutputData outputMessage) {
        String outputData = outputMessage.getTradeMessage();
        this.commandPanelVM.appendOutput(outputData);
        PlayerViewModel player1VM = playerPanelVM.getPlayerVMAt(outputMessage.getPlayer1Index());
        PlayerViewModel player2VM = playerPanelVM.getPlayerVMAt(outputMessage.getPlayer2Index());
        player1VM.setCash(outputMessage.getPlayer1NewMoney());
        player2VM.setCash(outputMessage.getPlayer2NewMoney());
        List<String> player1NewProperty = Arrays.asList(outputMessage.getPlayer1NewProperty());
        List<String> player2NewProperties = Arrays.asList(outputMessage.getPlayer2NewProperty());
        player1VM.addPropertyAbbrs(player1NewProperty);
        player2VM.addPropertyAbbrs(player2NewProperties);
        playerPanelVM.notifyListeners();
        int[] player1NewPropertyIndex = outputMessage.getPlayer1NewPropertyIndex().stream().mapToInt(i->i).toArray();
        int[] player2NewPropertyIndex = outputMessage.getPlayer2NewPropertyIndex().stream().mapToInt(i->i).toArray();
        for (int index : player1NewPropertyIndex) {
            TileViewModel tileVM = boardPanelVM.getTileVMAt(index);
            tileVM.setOwnershipIndex(outputMessage.getPlayer1Index());
        }
        for (int index : player2NewPropertyIndex) {
            TileViewModel tileVM = boardPanelVM.getTileVMAt(index);
            tileVM.setOwnershipIndex(outputMessage.getPlayer2Index());
        }
        boardPanelVM.notifyListeners();
        commandPanelVM.notifyListeners();

    }
    //Getter and Setter Methods
    public CommandPanelViewModel getCommandPanelVM() {
        return commandPanelVM;
    }
    public PlayerPanelViewModel getPlayerPanelVM() {
        return playerPanelVM;
    }
    public PlayerViewModel getPlayerVM() {
        return playerVM;
    }
    public BoardPanelViewModel getBoardPanelVM() {
        return boardPanelVM;
    }
    public TileViewModel getTileVM() {
        return tileVM;
    }
    public void setCommandPanelVM(CommandPanelViewModel commandPanelVM) {
        this.commandPanelVM = commandPanelVM;
    }
    public void setPlayerPanelVM(PlayerPanelViewModel playerPanelVM) {
        this.playerPanelVM = playerPanelVM;
    }
    public void setPlayerVM(PlayerViewModel playerVM) {
        this.playerVM = playerVM;
    }
    public void setBoardPanelVM(BoardPanelViewModel boardPanelVM) {
        this.boardPanelVM = boardPanelVM;
    }
    public void setTileVM(TileViewModel tileVM) {
        this.tileVM = tileVM;
    }

}
