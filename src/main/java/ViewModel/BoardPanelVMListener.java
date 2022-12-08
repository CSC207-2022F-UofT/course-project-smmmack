package ViewModel;

public interface BoardPanelVMListener{
    /**
     * The view model that calls for update should pass itself to the listener
     * @param viewModel the view model that calls for update itself
     */
    void performAction(BoardPanelViewModel viewModel);
}
