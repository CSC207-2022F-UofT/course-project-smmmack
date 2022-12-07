package ViewModel;

public interface CommandPanelVMListener {
    /**
     * The view model that calls for update should pass itself to the listener
     * @param viewModel the view model that calls for update itself
     */
    void performAction(CommandPanelViewModel viewModel);
}

