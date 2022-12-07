package ViewModel;

public interface PlayerPanelVMListener {
    /**
     * The view model that calls for update should pass itself to the listener
     * @param viewModel the view model that calls for update itself
     */
    void performAction(PlayerPanelViewModel viewModel);
}
