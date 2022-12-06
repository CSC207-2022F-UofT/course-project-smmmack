package ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Currently simply a list of player VMs. more contents may be added later.
 */
public class PlayerPanelViewModel {
    private List<PlayerViewModel> playerVMs;
    private List<PlayerPanelVMListener> listeners;

    public PlayerPanelViewModel() {
        this(new ArrayList<>());
    }

    public PlayerPanelViewModel(List<PlayerViewModel> playerVMs) {
        this.playerVMs = playerVMs;
        this.listeners = new ArrayList<>();
    }

    //setters

    public void setPlayerVMs(List<PlayerViewModel> playerVMs) {
        this.playerVMs = playerVMs;
    }

    //getters

    public List<PlayerViewModel> getPlayerVMs() {
        return playerVMs;
    }

    //other getters

    public PlayerViewModel getPlayerVMAt(int index) {
        return this.playerVMs.get(index);
    }

    //other setters

    public void addListener(PlayerPanelVMListener listener) {
        this.listeners.add(listener);
    }

    public boolean removeListener(PlayerPanelVMListener listener) {
        return this.listeners.remove(listener);
    }

    public void addPlayerViewModel(PlayerViewModel viewModel) {
        this.playerVMs.add(viewModel);
    }

    //other methods

    public void notifyListeners() {
        for (PlayerPanelVMListener listener: listeners) {
            listener.performAction(this);
        }
    }
}
